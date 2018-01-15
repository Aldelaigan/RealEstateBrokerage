package realestatebrokerage.models.storageandsystemmodels;

import realestatebrokerage.models.propertymodels.Property;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Storage implements Serializable{
    private ArrayList<Property> propertyArrayList = new ArrayList<>();
    private ArrayList<String> loginArrayList = new ArrayList<>();
    private HashMap<String,Integer> loginAndHashPassword = new HashMap<>();
    private HashMap<String,User> loginAndUser = new HashMap<>();
    private HashMap<String,ArrayList<String>> loginAndMessages = new HashMap<>();
    private HashMap<Property,ArrayList<String>> propertyAndLogins = new HashMap<>(); //Property and its observers
    private HashMap<String,ArrayList<Property>> loginAndProperties = new HashMap<>(); //Owner and his properties
    private HashMap<String,ArrayList<Integer>> loginAndPropertiesHistory= new HashMap<>(); //User and his view history


    public ArrayList<Property> getPropertyArrayList() {
        return propertyArrayList;
    }

    public void setPropertyArrayList(ArrayList<Property> propertyArrayList) {
        this.propertyArrayList = propertyArrayList;
    }

    public ArrayList<String> getLoginArrayList() {
        return loginArrayList;
    }

    public void setLoginArrayList(ArrayList<String> loginArrayList) {
        this.loginArrayList = loginArrayList;
    }

    public HashMap<String, Integer> getLoginAndHashPassword() {
        return loginAndHashPassword;
    }

    public void setLoginAndHashPassword(HashMap<String, Integer> loginAndHashPassword) {
        this.loginAndHashPassword = loginAndHashPassword;
    }

    public HashMap<String, User> getLoginAndUser() {
        return loginAndUser;
    }

    public void setLoginAndUser(HashMap<String, User> loginAndUser) {
        this.loginAndUser = loginAndUser;
    }

    public HashMap<String, ArrayList<String>> getLoginAndMessages() {
        return loginAndMessages;
    }

    public void setLoginAndMessages(HashMap<String, ArrayList<String>> loginAndMessages) {
        this.loginAndMessages = loginAndMessages;
    }

    public HashMap<Property, ArrayList<String>> getPropertyAndLogins() {
        return propertyAndLogins;
    }

    public void setPropertyAndLogins(HashMap<Property, ArrayList<String>> propertyAndLogins) {
        this.propertyAndLogins = propertyAndLogins;
    }

    public HashMap<String, ArrayList<Property>> getLoginAndProperties() {
        return loginAndProperties;
    }

    public void setLoginAndProperties(HashMap<String, ArrayList<Property>> loginAndProperties) {
        this.loginAndProperties = loginAndProperties;
    }

    public HashMap<String, ArrayList<Integer>> getLoginAndPropertiesHistory() {
        return loginAndPropertiesHistory;
    }

    public void setLoginAndPropertiesHistory(HashMap<String, ArrayList<Integer>> loginAndPropertiesHistory) {
        this.loginAndPropertiesHistory = loginAndPropertiesHistory;
    }
}
