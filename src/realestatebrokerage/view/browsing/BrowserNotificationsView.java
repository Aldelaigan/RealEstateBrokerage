package realestatebrokerage.view.browsing;

import java.util.Scanner;

public class BrowserNotificationsView extends BrowserView {
    public void printMessage(String message){
        System.out.println(message);
    }


    public String getMenuOptions(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
