package realestatebrokerage.controllers;

import realestatebrokerage.util.DataBase;
import realestatebrokerage.models.propertymodels.Property;
import realestatebrokerage.view.browsing.BrowserPropertiesView;

import static realestatebrokerage.util.HashingManager.getPropertyType;

public class BrowserPropertiesController {

    private BrowserPropertiesView browserPropertiesView = new BrowserPropertiesView();
    private DataBase dataBase = DataBase.getInstance();
    private int chosenPropertyIndex = 0;

    public Action browserProperties() {
        int pageNumber = 1;
        int pages = dataBase.getPropertyList().size() / 10;
        if (pageNumber % 10 == 0)
            pages++;
        while (true) {
            showProperties(pageNumber);
            browserPropertiesView.printNavigation(pageNumber, pages);
            browserPropertiesView.printMenuOptions();
            String menuOption = browserPropertiesView.getMenuOptions();
            switch (menuOption) {
                case ("Next"):
                    System.out.println(pages);
                    if (pageNumber <= pages)
                        pageNumber++;
                    else
                        browserPropertiesView.printNoMorePages();
                    break;
                case ("Prev"):
                    if (pageNumber > 1)
                        pageNumber--;
                    else
                        browserPropertiesView.printNoPage0();
                    break;
                case ("Back"):
                    return Action.Back;
                case ("Exit"):
                    return Action.Exit;
                default:
                    try {
                        chosenPropertyIndex = Integer.valueOf(menuOption);
                    } catch (Exception e) {
                        browserPropertiesView.printBadMenuOption();
                        continue;
                    }
                    if (chosenPropertyIndex >= dataBase.getPropertyList().size()||chosenPropertyIndex<0) {
                        browserPropertiesView.printBadMenuOption();
                        continue;
                    }
                    return Action.SeeDetails;
            }
        }
    }

    public Integer returnChosenProperty() {
        return chosenPropertyIndex;
    }

    private void showProperties(int page) {
        browserPropertiesView.printProperty("No.", "Type", "Status", "Price");
        for (Integer i = (page - 1) * 10; i < page * 10 && i < dataBase.getPropertyList().size(); i++) {
            Property property = dataBase.getPropertyList().get(i);
            browserPropertiesView.printProperty(i.toString(), getPropertyType(property),
                    getPropertyStatus(property.isSold()), "" + property.getPrice());
        }
    }

    private String getPropertyStatus(boolean isSold) {
        if (isSold) {
            return ("SOLD");
        } else {
            return ("AVAILABLE");
        }
    }

    public enum Action {
        Back(1), Exit(2), SeeDetails(3);
        private int command;

        private Action(int command) {
            this.command = command;
        }

        public int getCommand() {
            return command;
        }

    }
}