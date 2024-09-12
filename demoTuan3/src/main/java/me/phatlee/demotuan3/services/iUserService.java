package me.phatlee.demotuan3.services;

import me.phatlee.demotuan3.models.UserModel;

public interface iUserService {
    UserModel checkLogin(String username, String password);
    UserModel findByUsername(String username);
}
