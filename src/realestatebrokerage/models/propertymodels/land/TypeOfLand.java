package realestatebrokerage.models.propertymodels.land;

import java.io.Serializable;

public enum TypeOfLand implements Serializable{
    buildingPlot, farmland;

    @Override
    public String toString(){
        switch (this){
            case farmland:
                return "Farmland";
            case buildingPlot:
                return "Building Plot";
            default:
                return null;
        }
    }
}
