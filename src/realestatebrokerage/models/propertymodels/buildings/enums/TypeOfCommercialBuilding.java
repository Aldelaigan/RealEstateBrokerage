package realestatebrokerage.models.propertymodels.buildings.enums;

import java.io.Serializable;

public enum TypeOfCommercialBuilding implements Serializable{
    Office,Warehouse,Gastronomic,Commercial;

    @Override
    public String toString() {
        switch (this){
            case Office:
                return "Office";
            case Warehouse:
                return "Warehouse";
            case Gastronomic:
                return "Gastronomic";
            case Commercial:
                return "Commercial";
            default:
                return null;
        }
    }
}
