package me.phatlee.demotuan3.dao.impl;

import me.phatlee.demotuan3.models.UserModel;

import java.util.List;

public class Register {
    // This class is used to check if the user can register or not
    // If the user can register, the user's information will be inserted into the database
    // Username input valid when it is not equal to previous username
    public boolean checkRegister(String username, String password, String email, int roleid, String phone) {
        if(username == null || password == null || email == null || phone == null) {
            return false;
        }

        if(username.isEmpty() || password.isEmpty() || email.isEmpty() || phone.isEmpty())
            return false;

        UserDaoimplData userDaoimplData = new UserDaoimplData();
        List<UserModel> users = userDaoimplData.findAll();
        for (UserModel user : users) {
            if(user.getUsername().equals(username)) {
                return false;
            }
        }

        UserModel userNew = new UserModel();
        userNew.setUsername(username);
        userNew.setPassword(password);
        userNew.setEmail(email);
        userNew.setRoleid(roleid);
        userNew.setPhone(phone);

        userDaoimplData.insert(userNew);
        return true;
    }

    public static void main(String[] args) {
        Register register = new Register();
        System.out.println(register.checkRegister("phatle", "phatlee", "phatlee", 1, "0124578963"));
    }
}
