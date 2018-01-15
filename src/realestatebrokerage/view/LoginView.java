package realestatebrokerage.view;

import java.util.Scanner;

public class LoginView extends View{
    private Scanner scanner = new Scanner(System.in);

    private void printLoginOptions(){
        System.out.println("Choose one of the following: \n1.Login\n2.Create Account\n3.Exit");
    }

    private void printWrongAction(){
        System.out.println("Wrong action taken, try one more time");
    }

    public void printLoginFailed(){
        System.out.println("Unknown login or password");
    }

    public void printLoginSucceeded(){
        System.out.println("Successful login");
    }

    public void printAccountCreationSucceeded(){
        System.out.println("Successful account creation, now login");
    }

    public void printUserNameTaken(){
        System.out.println("Username taken, try different one!");
    }

    public String getLoginOptions(){
        printLoginOptions();
        String option = scanner.nextLine();
        while(!(option.equals("1")||option.equals("2")||option.equals("3"))) {
            printWrongAction();
            printLoginOptions();
            option = scanner.nextLine();
        }
        return option;
    }

    public String getLogin(){
        System.out.println("Enter your login");
        return getAlphaNumeric();
    }
    public String getPassword(){
        System.out.println("Enter your password");
        return getAlphaNumeric();
    }

    public String[] getUserDetails(){
        String questions[] ={"Enter your name:","Enter your surname:","Enter your Phone Number: ","Enter your email: "};
        String answer[] = new String[4];
        System.out.println(questions[0]);
        answer[0]=getWord();
        System.out.println(questions[1]);
        answer[1]=getWord();
        System.out.println(questions[2]);
        answer[2]=getNumber();
        System.out.println(questions[3]);
        answer[3]=getEmail();
        return answer;
    }
}
