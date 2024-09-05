package me.phatlee.demotuan3.dao;

import me.phatlee.demotuan3.dao.impl.UserDaoimplData;
import me.phatlee.demotuan3.models.UserModel;

import java.util.List;

public class checkLogin {
    public boolean checkLogin(String username, String password) {
        if(username == null || password == null) {
            return false;
        }

        if(username.isEmpty())
            return false;

        UserDaoimplData userDaoimplData = new UserDaoimplData();
        List<UserModel> users = userDaoimplData.findAll();
        for (UserModel user : users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        checkLogin checkLogin = new checkLogin();
        System.out.println(checkLogin.checkLogin("phatle", "phatlee"));
    }
}
