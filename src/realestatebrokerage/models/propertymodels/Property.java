package realestatebrokerage.models.propertymodels;

import realestatebrokerage.models.propertymodels.buildings.abstractclasses.Building;
import realestatebrokerage.models.propertymodels.land.Land;

import java.io.Serializable;

public class Property implements Serializable{
    private Building buildingOnProperty;
    private Land land;
    private Address propertyAddress;
    private boolean sold;
    private int price;
    private String owner;


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold() {
        this.sold = true;
    }

    public void Sell(){
        setSold();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Property(Building buildingOnProperty, Land land, Address address){
        this.buildingOnProperty = buildingOnProperty;
        this.land=land;
        this.propertyAddress=address;
        sold = false;
    }


    public Address getPropertyAddress() {
        return propertyAddress;
    }

    public Building getBuildingOnProperty() {
        return buildingOnProperty;
    }

    public void setBuildingOnProperty(Building buildingOnProperty) {
        this.buildingOnProperty = buildingOnProperty;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }
}
