package realestatebrokerage.controllers;
import realestatebrokerage.util.DataBase;
import realestatebrokerage.view.browsing.BrowserNotificationsView;

public class BrowserNotificationsController {
    private BrowserNotificationsView browserNotificationsView = new BrowserNotificationsView();
    private String login;
    private DataBase dataBase=DataBase.getInstance();

    public void setLogin(String login){
        this.login = login;
    }

    public Action browserNotifications() {
        int pageNumber = 1;
        int pages = dataBase.getMessages(login).size()/10+1;
        if (dataBase.getMessages(login).size() == 0)
            pages=0;
        while (true) {
            showMessages(pageNumber);
            browserNotificationsView.printNavigation(pageNumber, pages);
            browserNotificationsView.printMenuOptions();
            String menuOption = browserNotificationsView.getMenuOptions();
            switch (menuOption) {
                case ("Next"):
                    if (pageNumber <= pages)
                        pageNumber++;
                    else
                        browserNotificationsView.printNoMorePages();
                    System.out.println(pages);
                    break;
                case ("Prev"):
                    if (pageNumber > 1)
                        pageNumber--;
                    else
                        browserNotificationsView.printNoPage0();
                    break;
                case ("Back"):
                    return Action.Back;
                default:
                    browserNotificationsView.printMenuOptions();
            }
        }
    }
    private void showMessages(int page){

        for (Integer i = (page - 1) * 10; i < page * 10 && i < dataBase.getMessages(login).size(); i++) {
            browserNotificationsView.printMessage(dataBase.getMessages(login).get(i));
        }
    }

    public enum Action {
        Back(1);
        private int command;

        private Action(int command) {
            this.command = command;
        }

        public int getCommand() {
            return command;
        }

    }
}
