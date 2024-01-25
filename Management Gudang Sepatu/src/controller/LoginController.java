package controller;

import java.util.ArrayList;

import model.UserModel;

public abstract class LoginController {
    protected ArrayList<UserModel> userList;

    public LoginController() {
        userList = new ArrayList<>();
        userList.add(new UserModel("admin", "admin"));
        userList.add(new UserModel("user", "user"));
    }

    public abstract String authentication(String username, String password);
}
