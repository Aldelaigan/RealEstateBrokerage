package realestatebrokerage.view;

import java.util.Scanner;

public class AddPropertyView extends View{
    Scanner scanner = new Scanner(System.in);

    public String[] askAddress(){
        String[] answer= new String[4];
        System.out.println("Enter street: ");
        answer[0] = getAlphaNumeric();
        System.out.println("Enter number: ");
        answer[1]= getNumber();
        System.out.println("Enter postcode: ");
        answer[2]= getPostCode();
        System.out.println("Enter city: ");
        answer[3]= getWords();
        return answer;
    }

    public int askPrice() {
        System.out.println("What is the price of property?");
        int price = Integer.valueOf(getNumber());
        while(price==0) {
            System.out.println("Price can't be equal to 0, try again.");
            price= Integer.valueOf(getNumber());
        }
        return price;
    }

    public String askTypeOfProperty(){
        String type;
        do {
            System.out.println("Chose Type of Property:\n1.Land\n2.Building\n3.Land and building");
            type = scanner.nextLine();
        }while (!(type.equals("1")||type.equals("2")||type.equals("3")));
        return type;
    }

    public String askBuildingType(){
        String type;
        do {
            System.out.println("What is a type of a Building?\n1.House\n2.Flat\n3.Commerce Office Building");
            type = scanner.nextLine();
        }while (!(type.equals("1")||type.equals("2")||type.equals("3")));
        return type;
    }

    public String askLandType(){
        String type;
        do {
            System.out.println("What is a type of land?\n1.Farmland\n2.Building plot");
            type = scanner.nextLine();
        }while (!(type.equals("1")||type.equals("2")));
        return type;
    }

    public int askLandSize(){
        System.out.println("What is a size of land?");
        int landSize=Integer.valueOf(getNumber());
        while(landSize==0) {
            System.out.println("Size of land can't be equal to 0, try again.");
            landSize= Integer.valueOf(getNumber());
        }
        return landSize;
    }

    public String askTypeOfHouse(){
        String type;
        do {
            System.out.println("What is a type of a House?\n1.Villa\n2.Terraced\n3.Semidetached");
            type = scanner.nextLine();
        }while (!(type.equals("1")||type.equals("2")||type.equals("3")));
        return type;
    }

    public String askTypeOfCommercialBuilding(){
        String type;
        do {
            System.out.println("What is a type of a House?\n1.Office\n2.Warehouse\n3.Gastronomic\n4.Commercial");
            type = scanner.nextLine();
        }while (!(type.equals("1")||type.equals("2")||type.equals("3")||type.equals("4")));
        return type;
    }

    public int askWhichFloor() {
        System.out.println("On which floor is it located?");
        return Integer.valueOf(getNumber());
    }

    public float askFloorSurface() {
        System.out.println("What is a floor surface?");
        int floorSurface = Integer.valueOf(getNumber());
        while(floorSurface==0) {
            System.out.println("Floor surface can't be equal to 0, try again.");
            floorSurface = Integer.valueOf(getNumber());
        }
        return floorSurface;
    }

    public int askBathrooms() {
        System.out.println("How many bathrooms does it have?");
        return Integer.valueOf(getNumber());
    }

    public int askRooms() {
        System.out.println("How many rooms does it have?");
        int rooms = Integer.valueOf(getNumber());
        while(rooms==0) {
            System.out.println("Number of rooms can't be equal to 0, try again.");
            rooms = Integer.valueOf(getNumber());
        }
        return rooms;
    }

    public int askBedrooms() {
        System.out.println("How many bedrooms does it have?");
        return Integer.valueOf(getNumber());
    }

    public int askNumberOfFloors(){
        System.out.println("How many floors does it have?");
        int floors = Integer.valueOf(getNumber());
        while(floors==0) {
            System.out.println("Number of rooms can't be equal to 0, try again.");
            floors = Integer.valueOf(getNumber());
        }
        return floors;
    }
}