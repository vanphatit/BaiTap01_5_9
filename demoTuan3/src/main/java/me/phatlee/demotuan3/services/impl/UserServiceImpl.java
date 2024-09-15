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

    @Override
    public boolean register(String username, String password, String email, int roleid, String phone) {
        return userDAO.insert(new UserModel(0,username, password, email, roleid, phone));
    }

    @Override
    public boolean checkExist(String username, String email) {
        if(userDAO.findByUsername(username) == null && userDAO.findByEmail(email) == null) {
            return false;
        }
        return true;
    }

    @Override
    public boolean updatePassword(String username, String password) {
        UserModel user = userDAO.findByUsername(username);
        if(user != null) {
            user.setPassword(password);
            return userDAO.update(user);
        }
        return false;
    }

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        //System.out.println(userService.checkLogin("john_doe", "password123"));
//        System.out.println(userService.register("ghetbug", "password123@",
//                "hi@gmail.com", 2, "1234567890"));
        System.out.println(userService.checkExist("hi", "john@example.com"));
    }
}
