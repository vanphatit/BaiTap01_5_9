package me.phatlee.demotuan3.dao;

import me.phatlee.demotuan3.models.UserModel;

import java.util.List;

public interface iUserDAO {
    List<UserModel> findAll();
    UserModel findByEmail(String id);
    UserModel findByUsername(String username);
    boolean insert(UserModel user);
    boolean update(UserModel user);
}
