package realestatebrokerage.controllers;

import realestatebrokerage.view.MenuView;

public class MenuController {
    private MenuView menuView = new MenuView();

    public Action menuChoiceAction() {
        Action action=Action.Null;
        do {
            menuView.printMenuOptions();
            action = action.setCommand(menuView.getMenuOptions());
        }while(action==Action.Null);
        return action;
    }

    public enum Action{
        BrowserProperties(1),Notifications(2),AddProperty(3),Logoff(4),Null(5);
        private int command;

        private Action(int command){
            this.command=command;
        }

        public int getCommand(){
            return command;
        }

        public Action setCommand(String input){
            switch (input){
                case "1":return BrowserProperties;
                case "2":return Notifications;
                case "3":return AddProperty;
                case "4":return Logoff;
                default: return Null;
            }
        }
    }
}
