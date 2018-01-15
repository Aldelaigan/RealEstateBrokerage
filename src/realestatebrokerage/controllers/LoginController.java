package realestatebrokerage.controllers;
import realestatebrokerage.util.DataBase;
import realestatebrokerage.models.storageandsystemmodels.User;
import realestatebrokerage.util.HashingManager;
import realestatebrokerage.view.LoginView;


public class LoginController {
    private LoginView loginView=new LoginView();
    private String login;
    private String password;
    private DataBase dataBase = DataBase.getInstance();

    public  String popLogin(){
        return login;
    }

    public void createAccount(){
        getLogin();
        boolean loginTaken;
        do {
            loginTaken=!checkIfLoginIsAvailable();
            if(loginTaken) {
                informUserNameIsTaken();
                getLogin();
            }
        }while(loginTaken);
        getPassword();
        createNewAccountInDatabase();
        addUserInformation();
        informRegistrationSucceeded();
    }


    public  Action menuChoiceAction() {
        Action action=Action.Null;
        action = action.setCommand(loginView.getLoginOptions());
        return action;
    }

    public  void getLogin(){
        login = loginView.getLogin();
    }

    public  void getPassword(){
        password = loginView.getPassword();
    }

    public  boolean validateLoginAndPassword(){
        return dataBase.isLoginTaken(login) && dataBase.getPasswordHash(login)== HashingManager.hashPassword(password);
    }

    public  void informLoginFailed(){
        loginView.printLoginFailed();
    }

    public  void informLoginSucceeded(){
        loginView.printLoginSucceeded();
    }

    private void informRegistrationSucceeded(){
        loginView.printAccountCreationSucceeded();
    }

    private void informUserNameIsTaken(){
        loginView.printUserNameTaken();
    }

    private boolean checkIfLoginIsAvailable(){
        return !dataBase.isLoginTaken(login);
    }

    public  void createNewAccountInDatabase(){
        dataBase.addUser(login, HashingManager.hashPassword(password),new User());
    }

    private void addUserInformation(){
        String[] userInfo = loginView.getUserDetails();
        User user = new User();
        user.setName(userInfo[0]);
        user.setSurname(userInfo[1]);
        user.setPhoneNumber(userInfo[2]);
        user.setEmail(userInfo[3]);
        dataBase.modifyUser(login,user);
    }

    public enum Action{
        Login(1),CreateAccount(2),Exit(3),Null(4);
        private int command;

        Action(int command){
            this.command=command;
        }

        public int getCommand(){
            return command;
        }

        public Action setCommand(String input){
            switch (input){
                case "1":return Login;
                case "2":return CreateAccount;
                case "3":return Exit;
            }
            return Null;
        }
    }
}
