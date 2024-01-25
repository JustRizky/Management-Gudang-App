package controller;

import model.UserModel;

public class UserController extends LoginController {

    @Override
    public String authentication(String username, String password) {
        for (UserModel user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user.getUsername().equals("user") ? "user" : "admin";
            }
        }
        return null;
    }
}
