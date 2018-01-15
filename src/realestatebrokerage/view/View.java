package realestatebrokerage.view;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class View {
    protected Scanner scanner = new Scanner(System.in);

    protected String getPhoneNumber(){
        String words = scanner.nextLine();
        Pattern p = Pattern.compile("[\\d]{9}+");
        Matcher m = p.matcher(words);
        while(!m.matches()){
            System.out.println("Expected a nine digit format");
            words = scanner.nextLine();
            m = p.matcher(words);
        }
        return words;
    }


    protected String getWords(){
        String words = scanner.nextLine();
        Pattern p = Pattern.compile("[a-zA-ZĄąŁłŹźŻŻÓóĘęŃńŚś ]+");
        Matcher m = p.matcher(words);
        while(!m.matches()){
            System.out.println("Expected a word");
            words = scanner.nextLine();
            m = p.matcher(words);
        }
        return words;
    }

    protected String getWord(){
        String name = scanner.nextLine();
        Pattern p = Pattern.compile("[a-zA-ZĄąŁłŹźŻŻÓóĘęŃńŚś]+");
        Matcher m = p.matcher(name);
        while(!m.matches()){
            System.out.println("Expected words");
            name = scanner.nextLine();
            m = p.matcher(name);
        }
        return name;
    }

    protected String getNumber(){
        String alphaNumeric = scanner.nextLine();
        alphaNumeric=alphaNumeric.replaceAll("\\s+",""); //Some people like to add spaces or tabs between numbers
        Pattern p = Pattern.compile("[\\d]+");
        Matcher m = p.matcher(alphaNumeric);
        while (!m.matches()){
            System.out.println("Expected a number, which is bigger then 0");
            alphaNumeric = scanner.nextLine();
            alphaNumeric = alphaNumeric.replaceAll("\\s+","");
            m = p.matcher(alphaNumeric);
        }
        return alphaNumeric;
    }

    protected String getAlphaNumeric(){
        String number = scanner.nextLine();
        Pattern p = Pattern.compile("[a-zA-Z0-9ĄąŁłŹźŻżÓóĘęŃńŚś]+");
        Matcher m = p.matcher(number);
        while (!m.matches()){
            System.out.println("Expected an alphanumeric");
            number = scanner.nextLine();
            m = p.matcher(number);
        }
        return number;
    }

    protected String getAlphaNumerics(){
        String number = scanner.nextLine();
        Pattern p = Pattern.compile("[a-zA-Z0-9ĄąŁłŹźŻżÓóĘęŃńŚś ]+");
        Matcher m = p.matcher(number);
        while (!m.matches()){
            System.out.println("Expected alphanumerics");
            number = scanner.nextLine();
            m = p.matcher(number);
        }
        return number;
    }

    protected String getPostCode(){
        String postcode = scanner.nextLine();
        Pattern p = Pattern.compile("\\d\\d-\\d\\d\\d");
        Matcher m = p.matcher(postcode);
        while(!m.matches()){
            System.out.println("Expected a XX-XXX format");
            postcode = scanner.nextLine();
            m = p.matcher(postcode);
        }
        return postcode;
    }

    protected String getEmail(){
        String email = scanner.nextLine();
        Pattern p = Pattern.compile("[\\w\\d]+@[\\w]+\\.[\\w]+");
        Matcher m = p.matcher(email);
        while(!m.matches()){
            System.out.println("Expected a emailname@site.something format");
            email = scanner.nextLine();
            m = p.matcher(email);
        }
        return email;
    }
}
