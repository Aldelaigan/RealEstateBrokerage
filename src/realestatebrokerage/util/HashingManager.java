package realestatebrokerage.util;

import realestatebrokerage.models.propertymodels.buildings.CommerceBuilding;
import realestatebrokerage.models.propertymodels.buildings.House;
import realestatebrokerage.models.propertymodels.buildings.abstractclasses.ResidentialBuilding;
import realestatebrokerage.models.propertymodels.Property;

public class HashingManager {
    public static int hashPassword(String password){
        int sum=0;
        for(int i=0;i<password.length();i++)
            sum+=password.charAt(i);
        return sum%127;
    }
    public static String getPropertyType(Property property){
        String string="";
        if(property.getBuildingOnProperty()!=null) {
            if (property.getBuildingOnProperty() instanceof ResidentialBuilding) {
                if (property.getBuildingOnProperty() instanceof House) {
                    string += ((House) property.getBuildingOnProperty()).getTypeOfHouse().toString();
                    string += " House";
                } else {
                    string += "Flat";
                }
            } else {
                string += ((CommerceBuilding) property.getBuildingOnProperty()).getTypeOfBuilding().toString();
            }
        }
        if(property.getLand()!=null&&string.equals("")){
            string+=property.getLand().getType().toString();
        }
        return string;
    }
}
