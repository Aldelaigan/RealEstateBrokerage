package realestatebrokerage.view.browsing;

import realestatebrokerage.view.View;

public abstract class BrowserView extends View {
    public void printNavigation(int pageNumber, int pages){
        StringBuilder output= new StringBuilder();
        if(pageNumber>1){
            output.append("<<<<");
        }

        for(int i = 25-output.length();i>=0;i--)
            output.append(" ");

        if (pages==0){
            output.append(0 + " Of " + 0);
        }else{
            output.append(pageNumber).append(" Of ").append(pages);
        }

        if(pageNumber<pages){
            for (int i =55-output.length();i>=0;i--)
                output.append(" ");
            output.append(">>>>");
        }
        System.out.println(output);
    }

    public void printMenuOptions(){
        System.out.println("Options:\nType in Number of property to view its details\nType 'Next' or 'Prev' to move\nType 'Back' to go back");
    }

    public void printNoMorePages(){
        System.out.println("Sorry, there are no more pages left");
    }

    public void printNoPage0(){
        System.out.println("Sorry, You cant go negative");
    }

    public void printBadMenuOption(){
        System.out.println("Sorry its a wrong menu option, try again");
    }
}
