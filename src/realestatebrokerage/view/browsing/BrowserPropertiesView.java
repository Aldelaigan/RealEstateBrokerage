package realestatebrokerage.view.browsing;

import java.util.Scanner;

public class BrowserPropertiesView extends BrowserView {
    private Scanner scanner = new Scanner(System.in);

    public void printProperty(String numeration,String type,String status,String price){
        StringBuilder output= new StringBuilder(numeration);
        for(int i = 4-output.length();i>=0;i--) // TODO: String.format()
            output.append(" ");
        output.append(type);
        for(int i = 25-output.length();i>=0;i--)
            output.append(" ");
        output.append(status);
        for(int i = 55-output.length();i>=0;i--)
            output.append(" ");
        output.append(price);
        System.out.println(output);
    }

    public String getMenuOptions(){
        return scanner.nextLine();
    }
}
