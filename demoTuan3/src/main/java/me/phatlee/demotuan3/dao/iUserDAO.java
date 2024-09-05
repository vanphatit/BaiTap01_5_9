package me.phatlee.demotuan3.dao;

import me.phatlee.demotuan3.models.UserModel;

import java.util.List;

public interface iUserDAO {
    List<UserModel> findAll();
    UserModel findById(String id);
    void insert(UserModel user);
}