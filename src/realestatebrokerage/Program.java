package realestatebrokerage;

import realestatebrokerage.controllers.*;
import realestatebrokerage.models.propertymodels.Property;
import realestatebrokerage.models.storageandsystemmodels.Storage;
import realestatebrokerage.models.storageandsystemmodels.User;
import realestatebrokerage.util.CommandGenerator;
import realestatebrokerage.util.DataBase;
import realestatebrokerage.util.HashingManager;

import static realestatebrokerage.util.CommandGenerator.*;
import static realestatebrokerage.util.StoringManager.*;

public class Program {
    private CommandGenerator generator = new CommandGenerator();
    private String currentlyLoggedInUser;
    private DataBase dataBase = DataBase.getInstance();

    Program(){
        Storage storage = deserialize();
        dataBase.setStorage(storage);
    }

    public int run(){
        while (true){
            switch (generator.getCurrentCommand()){
                case LoginMenu:
                    loginHandler();
                    break;
                case MainMenu:
                    mainMenuHandler();
                    break;
                case BrowserProperties:
                    browserPropertiesHandler();
                    break;
                case AddProperty:
                    addPropertyHandler();
                    break;
                case ViewProperty:
                    viewPropertyHandler();
                    break;
                case Notifications:
                    browserNotificationHandler();
                    break;
                case Exit:
                    serialize(dataBase.getStorage());
                    return 0;
            }
        }
    }

    private void loginHandler(){
        LoginController loginController = new LoginController();
        switch (loginController.menuChoiceAction()){
            case Login:
                loginController.getLogin();
                loginController.getPassword();
                if(loginController.validateLoginAndPassword()) {
                    loginController.informLoginSucceeded();
                    generator.feed(CommandType.LoginSuccessful);
                    currentlyLoggedInUser=loginController.popLogin();
                }else{
                    loginController.informLoginFailed();
                    generator.feed(CommandType.LoginUnsuccessful);
                }
                break;
            case CreateAccount:
                loginController.createAccount();
                loginController.createNewAccountInDatabase();
                generator.feed(CommandType.AccountCreationSuccessful);
                break;
            case Exit:
                generator.feed(CommandType.Exit);
                break;
        }
    }

    private void mainMenuHandler(){
        MenuController menuController = new MenuController();
        switch (menuController.menuChoiceAction()){
            case BrowserProperties:
                generator.feed(CommandType.BrowserProperties);
                break;
            case Notifications:
                generator.feed(CommandType.Notifications);
                break;
            case AddProperty:
                generator.feed(CommandType.AddProperty);
                break;
            case Logoff:
                generator.feed(CommandType.Logoff);
                break;
        }
    }
    
    private void addPropertyHandler(){
        AddPropertyController addPropertyController = new AddPropertyController();
        addPropertyController.setUserLogin(currentlyLoggedInUser);
        addPropertyController.addProperty();
        generator.feed(CommandType.MainMenu);
    }

    private void browserNotificationHandler(){
        BrowserNotificationsController browserNotificationsController = new BrowserNotificationsController();
        browserNotificationsController.setLogin(currentlyLoggedInUser);
        switch (browserNotificationsController.browserNotifications()){
            case Back:
                generator.feed(CommandType.MainMenu);
                break;
        }
    }

    private void browserPropertiesHandler(){
        BrowserPropertiesController browserPropertiesController = new BrowserPropertiesController();
        switch (browserPropertiesController.browserProperties()){
            case Back:
                generator.feed(CommandType.MainMenu);
                break;
            case Exit:
                generator.feed(CommandType.Exit);
            case SeeDetails:
                dataBase.addLastViewedPropertyIndex(currentlyLoggedInUser,browserPropertiesController.returnChosenProperty());
                generator.feed(CommandType.ViewProperty);
        }
    }

    private void viewPropertyHandler(){
        ViewPropertyController viewPropertyController = new ViewPropertyController();
        viewPropertyController.setLogin(currentlyLoggedInUser);
        int lastViewedPropertyIndex = dataBase.getLastViewedPropertyIndex(currentlyLoggedInUser);
        Property lastViewedProperty = dataBase.getPropertyList().get(lastViewedPropertyIndex);
        viewPropertyController.loadProperty(lastViewedProperty);
        switch (viewPropertyController.getMenuOptions()){
            case Back:
                generator.feed(CommandType.BrowserProperties);
                break;
            case Buy:
                lastViewedProperty.setSold();
                lastViewedProperty.setOwner(currentlyLoggedInUser);
                dataBase.addObservingLogin(lastViewedProperty,currentlyLoggedInUser);
                dataBase.notifyPropertySold(lastViewedProperty);
                generator.feed(CommandType.ViewProperty);
                break;
            case Observe:
                dataBase.addObservingLogin(lastViewedProperty,currentlyLoggedInUser);
                generator.feed(CommandType.ViewProperty);
                break;
            case UnObserve:
                dataBase.removeObservingLogin(lastViewedProperty,currentlyLoggedInUser);
                generator.feed(CommandType.ViewProperty);
                break;
            case ChangePrice:
                viewPropertyController.changePrice();
                break;
        }
    }
}
