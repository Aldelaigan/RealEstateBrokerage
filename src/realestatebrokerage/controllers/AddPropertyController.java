package realestatebrokerage.controllers;

import realestatebrokerage.models.propertymodels.buildings.*;
import realestatebrokerage.models.propertymodels.buildings.abstractclasses.Building;
import realestatebrokerage.models.propertymodels.buildings.abstractclasses.ResidentialBuilding;
import realestatebrokerage.models.propertymodels.buildings.enums.TypeOfCommercialBuilding;
import realestatebrokerage.models.propertymodels.buildings.enums.TypeOfHouse;
import realestatebrokerage.models.propertymodels.land.Land;
import realestatebrokerage.models.propertymodels.land.TypeOfLand;
import realestatebrokerage.models.propertymodels.Address;
import realestatebrokerage.models.propertymodels.Property;
import realestatebrokerage.util.DataBase;
import realestatebrokerage.view.AddPropertyView;

public class AddPropertyController {
    private AddPropertyView addPropertyView = new AddPropertyView();
    private Property property;
    private Building building;
    private Land land;
    private Address address;
    private DataBase dataBase = DataBase.getInstance();
    private String login;

    public void addProperty(){
        generateProperty();
        setPropertyOwner(login);
        dataBase.addProperty(property);
        dataBase.addObservingLogin(property,login);
    }

    public void setUserLogin(String login){
        this.login=login;
    }



    public Property getProperty() {
        return property;
    }

    private void generateProperty(){
        switch (getTypeOfProperty()){
            case Land:
                generateLand();
                break;
            case Building:
                generateBuilding();
                break;
            case LandAndBuilding:
                generateLand();
                generateBuilding();
                break;
        }
        generateAddress();
        property=new Property(building,land,address);
        property.setPrice(addPropertyView.askPrice());
    }

    private void generateLand(){
        TypeOfLand typeOfLand = null;
        Integer landSize;
        switch (addPropertyView.askLandType()){
            case "1":
                typeOfLand=TypeOfLand.buildingPlot;
                break;
            case "2":
                typeOfLand=TypeOfLand.farmland;
                break;
        }
        landSize = addPropertyView.askLandSize();
        land = new Land(typeOfLand,landSize);
    }

    private void setPropertyOwner(String login){
        property.setOwner(login);
    }

    private void generateBuilding() {
        switch (addPropertyView.askBuildingType()) {
            case "1":
                building = new House();
                getTypeOfHouse((House) building);
                getResidentialBuildingDetails((ResidentialBuilding) building);
                break;
            case "2":
                building = new Flat();
                getFlatDetails((Flat) building);
                getResidentialBuildingDetails((ResidentialBuilding) building);
                break;
            case "3":
                building = new CommerceBuilding();
                getTypeOfCommercialBuilding((CommerceBuilding) building);
                break;
        }
        getBuildingDetails(building);
}

    private void generateAddress(){
        String[] string = addPropertyView.askAddress();
        address = new Address(string[0],string[1],string[2],string[3]);
    }

    private void getTypeOfHouse(House house){
        switch (addPropertyView.askTypeOfHouse()){
            case "1":
                house.setTypeOfHouse(TypeOfHouse.Villa);
                break;
            case "2":
                house.setTypeOfHouse(TypeOfHouse.Terraced);
                break;
            case "3":
                house.setTypeOfHouse(TypeOfHouse.Semidetached);
                break;
        }
    }

    private void getTypeOfCommercialBuilding(CommerceBuilding commerceBuilding){
        switch (addPropertyView.askTypeOfCommercialBuilding()){
            case "1":
                commerceBuilding.setTypeOfBuilding(TypeOfCommercialBuilding.Office);
                break;
            case "2":
                commerceBuilding.setTypeOfBuilding(TypeOfCommercialBuilding.Warehouse);
                break;
            case "3":
                commerceBuilding.setTypeOfBuilding(TypeOfCommercialBuilding.Gastronomic);
                break;
            case "4":
                commerceBuilding.setTypeOfBuilding(TypeOfCommercialBuilding.Commercial);
                break;
        }
    }

    private void getBuildingDetails(Building building){
        building.setFloorSurface(addPropertyView.askFloorSurface());
        building.setFloors(addPropertyView.askNumberOfFloors());
    }

    private void getFlatDetails(Flat flat){
        flat.setOnFloor(addPropertyView.askWhichFloor());
    }

    private void getResidentialBuildingDetails(ResidentialBuilding building){
        building.setRooms(addPropertyView.askRooms());
        building.setBathrooms(addPropertyView.askBathrooms());
        building.setSleepingRooms(addPropertyView.askBedrooms());
    }

    private Action getTypeOfProperty(){
         Action action = Action.Null;
         switch (addPropertyView.askTypeOfProperty()){
             case ("1"):
                 return Action.Land;
             case ("2"):
                 return Action.Building;
             case ("3"):
                 return Action.LandAndBuilding;
    }
         return action;
    }

    void setPropertyPrice(){
       property.setPrice(addPropertyView.askPrice());
    }

    public void setProperty(Property property){
        this.property=property;
    }

    public enum Action{
        Land(1),Building(2),LandAndBuilding(3),Null(4);
        private int command;

        private Action(int command){
            this.command=command;
        }

        public int getCommand(){
            return command;
        }

        public Action setCommand(String input){
            switch (input){
                case "1":return Land;
                case "2":return Building;
                case "3":return LandAndBuilding;
            }
            return Null;
        }
    }


}
