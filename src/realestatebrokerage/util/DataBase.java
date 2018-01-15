package realestatebrokerage.util;
import realestatebrokerage.models.propertymodels.Property;
import realestatebrokerage.models.storageandsystemmodels.Storage;
import realestatebrokerage.models.storageandsystemmodels.User;

import java.io.Serializable;
import java.util.ArrayList;

public class DataBase implements Serializable{

    private Storage storage;
    private static DataBase instance = new DataBase();
    private DataBase(){
    }
    public static DataBase getInstance(){
        return instance;
    }

    public static void setInstance(DataBase dataBase){
        instance=dataBase;
    }

    public void setStorage(Storage storage){
        this.storage=storage;
    }

    public Storage getStorage(){
        return storage;
    }


    public ArrayList<Property> getPropertyList() {
        return storage.getPropertyArrayList();
    }

    public void addProperty(Property property){
        storage.getPropertyArrayList().add(property);
        storage.getPropertyAndLogins().put(property,new ArrayList<String>());
    }

    public Integer getPasswordHash(String login){
        return storage.getLoginAndHashPassword().get(login);
    }

    public void addUser(String login, int passwordHash, User user){
        storage.getLoginArrayList().add(login);
        storage.getLoginAndHashPassword().put(login,passwordHash);
        storage.getLoginAndUser().put(login,user);
        storage.getLoginAndMessages().put(login,new ArrayList<String>());
        storage.getLoginAndProperties().put(login, new ArrayList<Property>());
        storage.getLoginAndPropertiesHistory().put(login,new ArrayList<Integer>());
    }

    public User getUser(String login){
        return storage.getLoginAndUser().get(login);
    }

    public void modifyUser(String login,User user) {
        storage.getLoginAndUser().replace(login,user); //piekny kod, polecam Jarek (C)
    }

    public ArrayList<String> getMessages(String login){
        return storage.getLoginAndMessages().get(login);
    }

    private void addMessage(String login, String message){
        ArrayList<String> messages = storage.getLoginAndMessages().get(login);
        messages.add(message);
        storage.getLoginAndMessages().replace(login,messages);
    }

    public ArrayList<String> getObservingLogins(Property property){
        return storage.getPropertyAndLogins().get(property);
    }

    public void addObservingLogin(Property property, String login){
        ArrayList<String> logins = storage.getPropertyAndLogins().get(property);
        logins.add(login);
        storage.getPropertyAndLogins().replace(property,logins);
    }

    public void removeObservingLogin(Property property, String login){
        ArrayList<String> logins = storage.getPropertyAndLogins().get(property);
        logins.remove(login);
        storage.getPropertyAndLogins().replace(property,logins);
    }

    public boolean isLoginTaken(String login){
        return storage.getLoginArrayList().contains(login);
    }

    public Integer getLastViewedPropertyIndex(String login){
        return storage.getLoginAndPropertiesHistory().get(login).get(storage.getLoginAndPropertiesHistory().get(login).size()-1); // czy da sie czytelniej?
    }

    public void addLastViewedPropertyIndex(String login, Integer index){
        ArrayList<Integer> indexes = storage.getLoginAndPropertiesHistory().get(login);
        indexes.add(index);
        storage.getLoginAndPropertiesHistory().replace(login,indexes);
    }

    public void notifyPropertySold(Property property){
        ArrayList<String> loginsOfObservers = storage.getPropertyAndLogins().get(property);
        for (String login:loginsOfObservers){
            addMessage(login,"Property at address "+property.getPropertyAddress().toString()+" was sold");
            System.out.println(getMessages(login).get(0));
        }
    }

    public void notifyPropertyPriceChanged(Property property,int old, int current){
        ArrayList<String> loginsOfObservers = storage.getPropertyAndLogins().get(property);
        for (String login:loginsOfObservers){
            addMessage(login,"Property at address "+property.getPropertyAddress().toString()+" price was changed from "+old+" to "+current);
            System.out.println(getMessages(login).get(0));
        }
    }
}
