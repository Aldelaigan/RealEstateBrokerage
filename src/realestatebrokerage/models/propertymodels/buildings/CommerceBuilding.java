package realestatebrokerage.models.propertymodels.buildings;

import realestatebrokerage.models.propertymodels.buildings.abstractclasses.Building;
import realestatebrokerage.models.propertymodels.buildings.enums.TypeOfCommercialBuilding;

public class CommerceBuilding extends Building {
    private TypeOfCommercialBuilding typeOfBuilding;

    public TypeOfCommercialBuilding getTypeOfBuilding() {
        return typeOfBuilding;
    }

    public void setTypeOfBuilding(TypeOfCommercialBuilding typeOfBuilding) {
        this.typeOfBuilding = typeOfBuilding;
    }
}
