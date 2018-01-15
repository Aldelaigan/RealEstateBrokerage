package realestatebrokerage.models.propertymodels.buildings.abstractclasses;

import java.io.Serializable;

public abstract class Building implements Serializable{
    protected int floors;
    protected float floorSurface;

    public float getFloorSurface() {
        return floorSurface;
    }

    public void setFloorSurface(float floorSurface) {
        this.floorSurface = floorSurface;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }
}
