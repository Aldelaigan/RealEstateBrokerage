package realestatebrokerage.view;

import java.util.Scanner;

public class MenuView {
    Scanner scanner = new Scanner(System.in);

    public void printMenuOptions(){
        System.out.println("Options:\n1.Properties\n2.Notifications\n3.Add property\n4.Logout");
    }

    public String getMenuOptions(){
        String option = scanner.nextLine();
        return option;
    }
}
