package realestatebrokerage.models.propertymodels.buildings.abstractclasses;

public abstract class ResidentialBuilding extends Building {
    protected int bathrooms;
    protected int sleepingRooms;
    protected int rooms;

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getSleepingRooms() {
        return sleepingRooms;
    }

    public void setSleepingRooms(int sleepingRooms) {
        this.sleepingRooms = sleepingRooms;
    }
}
