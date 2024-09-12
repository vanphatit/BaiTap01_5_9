package me.phatlee.demotuan3.services.impl;

import me.phatlee.demotuan3.dao.iUserDAO;
import me.phatlee.demotuan3.dao.impl.UserDaoimplData;
import me.phatlee.demotuan3.models.UserModel;
import me.phatlee.demotuan3.services.iUserService;

public class UserServiceImpl implements iUserService {

    iUserDAO userDAO = new UserDaoimplData();

    @Override
    public UserModel checkLogin(String username, String password) {
        UserModel user = userDAO.findByUsername(username);
        if(user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public UserModel findByUsername(String username) {
        return userDAO.findByUsername(username);
    }

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        System.out.println(userService.checkLogin("john_doe", "password123"));
    }
}
