package realestatebrokerage.controllers;

import realestatebrokerage.models.propertymodels.buildings.*;
import realestatebrokerage.models.propertymodels.buildings.abstractclasses.Building;
import realestatebrokerage.models.propertymodels.buildings.abstractclasses.ResidentialBuilding;
import realestatebrokerage.models.propertymodels.land.Land;
import realestatebrokerage.models.propertymodels.Property;
import realestatebrokerage.util.DataBase;
import realestatebrokerage.view.PropertyView;

import static realestatebrokerage.util.HashingManager.getPropertyType;

public class ViewPropertyController {
    private Property viewedProperty;
    private PropertyView propertyView = new PropertyView();
    private String login;
    private DataBase dataBase = DataBase.getInstance();

    public void setLogin(String login){
        this.login = login;
    }

    private boolean isPropertyObserved(){
        return dataBase.getObservingLogins(viewedProperty).contains(login);
    }

    private boolean isPropertyOwned(){
        return viewedProperty.getOwner().equals(login);
    }

    public Action getMenuOptions() {
        while (true) {
            printWholeInfo();
            int menuOption = propertyView.getMenuOption(viewedProperty.isSold(), isPropertyObserved(), isPropertyOwned());
            if (viewedProperty.isSold())
                return Action.Back;
            else if (isPropertyOwned()) {
                switch (menuOption) {
                    case 1:
                        return Action.Back;
                    case 2:
                        return Action.ChangePrice;
                }
            } else {
                switch (menuOption) {
                    case 1:
                        return Action.Buy;
                    case 2:
                        if (isPropertyObserved())
                            return Action.UnObserve;
                        else
                            return Action.Observe;
                    case 3:
                        return Action.Back;
                }
            }
        }
    }

    public void loadProperty(Property viewedProperty){
        this.viewedProperty=viewedProperty;
    }

    private void printPropertyDetails() {
        System.out.println("Property ");
        if (viewedProperty.getBuildingOnProperty() != null) {
            printBuildingDetails(viewedProperty.getBuildingOnProperty());
        }
        if (viewedProperty.getLand() != null) {
            printLandDetails(viewedProperty.getLand());
        }
        System.out.println("Price: " + viewedProperty.getPrice());
        propertyView.printPropertyOwner(viewedProperty.getOwner());
    }

    private void printBuildingDetails(Building building) {
        propertyView.printBuildingDetails(building.getFloors(),building.getFloorSurface());
        if (building instanceof ResidentialBuilding) {
            propertyView.printResidentialBuildingDetails(((ResidentialBuilding) building).getBathrooms(),
                    ((ResidentialBuilding) building).getSleepingRooms(),
                    ((ResidentialBuilding) building).getRooms() );
            if (building instanceof Flat) {
                propertyView.printFlatDetails(((Flat) building).getOnFloor());
            } else {
                propertyView.printHouseDetails(((House) building).getTypeOfHouse().toString());
            }
        } else {
            propertyView.printCommerceBuildingDetails(((CommerceBuilding) building).getTypeOfBuilding().toString());
        }
        propertyView.printAddress(viewedProperty.getPropertyAddress().getStreet(),
                                    viewedProperty.getPropertyAddress().getNumber(),
                                        viewedProperty.getPropertyAddress().getNumber());
    }

    private void printWholeInfo(){
        propertyView.printPropertyBasicInfo(getPropertyType(viewedProperty),
                getPropertyStatus(viewedProperty.isSold()), "" + viewedProperty.getPrice());
        printPropertyDetails();

    }

    private void printLandDetails(Land land) {
        propertyView.printLandType(land.getType().toString());
        propertyView.printLandSize(land.getSize());
    }

    private String getPropertyStatus(boolean isSold) {
        if (isSold) {
            return ("SOLD");
        } else {
            return ("AVAILABLE");
        }
    }

    public void changePrice(){
        long currentPrice = viewedProperty.getPrice();
        AddPropertyController addPropertyController = new AddPropertyController();
        addPropertyController.setProperty(viewedProperty);
        addPropertyController.setPropertyPrice();
        long newPrice = viewedProperty.getPrice();
        dataBase.notifyPropertyPriceChanged(viewedProperty,currentPrice,newPrice);
    }

    public enum Action{
        Buy(1),Observe(2),UnObserve(3),Back(4),ChangePrice(5),Null(6);
        private int command;
        private Action(int command){
            this.command=command;
        }

        public int getCommand(){
            return command;
        }

        public Action setCommand(String input){
            switch (input){
                case "1":return Buy;
                case "2":return Observe;
                case "3":return UnObserve;
                case "4":return Back;
                case "5":return ChangePrice;
            }
            return Null;
        }
    }
}
