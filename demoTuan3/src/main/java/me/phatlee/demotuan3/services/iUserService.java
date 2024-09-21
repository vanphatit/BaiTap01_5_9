package me.phatlee.demotuan3.services;

import me.phatlee.demotuan3.models.UserModel;

public interface iUserService {
    UserModel checkLogin(String username, String password);
    UserModel findByUsername(String username);
    boolean register(String username, String password, String email, int roleid, String phone, String fullname);
    boolean checkExist(String username, String email);
    boolean updatePassword(String username, String password);
    boolean update(UserModel user);
}
