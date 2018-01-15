package realestatebrokerage.util;

public class CommandGenerator {

    public CommandGenerator(){
        currentCommand=CommandType.LoginMenu;
    }

    CommandType currentCommand;

    public enum CommandType{
        LoginMenu(0),
        LoginSuccessful(1),
        LoginUnsuccessful(2),
        AccountCreationSuccessful(3),
        AccountCreationUnsuccessful(4),
        MainMenu(10),
        BrowserProperties(11),
        Notifications(12),
        AddProperty(13),
        Logoff(14),
        ViewProperty(20),
        Exit(99);
        private int command;

        CommandType(int command){
            this.command=command;
        }

    }

    public void feed(CommandType command){ //Bundle bundle
        if(command==CommandType.LoginUnsuccessful||command==CommandType.AccountCreationSuccessful||command==CommandType.AccountCreationUnsuccessful)
            currentCommand=CommandType.LoginMenu;
        if(command==CommandType.LoginSuccessful)
            currentCommand=CommandType.MainMenu;
        if(command==CommandType.BrowserProperties)
            currentCommand=CommandType.BrowserProperties;
        if(command==CommandType.Exit)
            currentCommand=CommandType.Exit;
        if(command==CommandType.AddProperty)
            currentCommand=CommandType.AddProperty;
        if(command==CommandType.MainMenu)
            currentCommand=CommandType.MainMenu;
        if(command==CommandType.ViewProperty)
            currentCommand=CommandType.ViewProperty;
        if(command==CommandType.Logoff)
            currentCommand=CommandType.LoginMenu;
        if(command==CommandType.Notifications)
            currentCommand=CommandType.Notifications;
    }

    public CommandType getCurrentCommand() {
        return currentCommand;
    }
}
