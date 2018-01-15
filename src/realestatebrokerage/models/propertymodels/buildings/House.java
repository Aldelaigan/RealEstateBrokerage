package realestatebrokerage.models.propertymodels.buildings;

import realestatebrokerage.models.propertymodels.buildings.abstractclasses.ResidentialBuilding;
import realestatebrokerage.models.propertymodels.buildings.enums.TypeOfHouse;

public class House extends ResidentialBuilding {
    private TypeOfHouse typeOfHouse;

    public TypeOfHouse getTypeOfHouse() {
        return typeOfHouse;
    }

    public void setTypeOfHouse(TypeOfHouse typeOfHouse) {
        this.typeOfHouse = typeOfHouse;
    }
}
