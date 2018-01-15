package realestatebrokerage.view;

public class PropertyView extends View{

    public void printMenuOptions(boolean isSold,boolean isObserved,boolean isOwned){
        if(isSold||isOwned) {
            System.out.println("1.Back\n2.Change price");
        }else{
            System.out.println("1.Buy");
            if(isObserved){
                System.out.println("2.Unobserve");
            }else{
                System.out.println("2.Observe");
            }
            System.out.println("3.Back");
        }
    }

    public int getMenuOption(boolean isSold,boolean isObserved,boolean isOwned){
        if(isOwned)
            System.out.println("You own this property");
        if(isObserved)
            System.out.println("You observe this property");
        Integer type;
        do {
            printMenuOptions(isSold,isObserved,isOwned);
            type = Integer.valueOf(getNumber());
        }while ((type != 1) && (type != 2 && !isSold) && (!isOwned && type != 3));
        return type;
    }


    public void printPropertyBasicInfo(String type,String address,String price){
        StringBuilder output= new StringBuilder(type);
        for(int i = 25-output.length();i>=0;i--)
            output.append(" ");
        output.append(address);
        for(int i = 55-output.length();i>=0;i--)
            output.append(" ");
        output.append(price);
        System.out.println(output);
    }

    public void printPropertyOwner(String login){
        System.out.println("Property Owner: "+login);
    }

    public void printLandType(String landType) {
        System.out.println("Land type is " + landType);
    }
    public void printLandSize(Float size) {
        System.out.println("Land size is " + size + " square meters");
    }

    public void printBuildingDetails(int numberOfFloors,float surface){
        System.out.println("Number of floors: " + numberOfFloors);
        System.out.println("Floor surface: " + surface);
    }
    public void printResidentialBuildingDetails(int bathrooms,int bedrooms,int rooms){
        System.out.println("Number of bathrooms: " + bathrooms);
        System.out.println("Number of sleeping rooms: " + bathrooms);
        System.out.println("Number of rooms: " + rooms);
    }

    public void printFlatDetails(int floor){
        System.out.println("Flat on a floor: " + floor);
    }

    public void printHouseDetails(String houseType){
        System.out.println("Type of House: " + houseType);
    }

    public void printCommerceBuildingDetails(String CommerceType){
        System.out.println("Type of House: " + CommerceType);
    }

    public void printAddress(String street,String number,String city){
        System.out.println("Address: "+street+"street "+number+" "+city);
    }
}