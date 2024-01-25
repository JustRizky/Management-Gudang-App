package app;

import controller.AdminController;
import controller.LoginController;
import view.LoginView;

public class Main {
    public static void main(String[] args) {
        LoginController loginController = new AdminController();
        LoginView view = new LoginView(loginController);

    }
}
