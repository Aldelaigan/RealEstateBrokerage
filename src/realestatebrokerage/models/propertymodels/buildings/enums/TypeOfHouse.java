package realestatebrokerage.models.propertymodels.buildings.enums;

import java.io.Serializable;

public enum TypeOfHouse implements Serializable{
    Semidetached,Terraced,Villa;

    @Override
    public String toString() {
        switch (this){
            case Villa:
                return "Villa";
            case Terraced:
                return "Terraced";
            case Semidetached:
                return "Semidetached";
            default:
                return null;
        }
    }
}
