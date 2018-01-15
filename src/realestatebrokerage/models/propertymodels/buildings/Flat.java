package realestatebrokerage.models.propertymodels.buildings;

import realestatebrokerage.models.propertymodels.buildings.abstractclasses.ResidentialBuilding;

public class Flat extends ResidentialBuilding {
    private int onFloor;

    public int getOnFloor() {
        return onFloor;
    }

    public void setOnFloor(int onFloor) {
        this.onFloor = onFloor;
    }
}
