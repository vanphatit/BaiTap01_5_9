package me.phatlee.demotuan3.dao.impl;

import me.phatlee.demotuan3.configs.DBconnectMySQL;
import me.phatlee.demotuan3.dao.iUserDAO;
import me.phatlee.demotuan3.models.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoimplData extends DBconnectMySQL implements iUserDAO {

    public Connection conn = null;
    public PreparedStatement preparedStatement = null;
    public ResultSet resultSet = null;

    @Override
    public List<UserModel> findAll() {
        String sql = "SELECT * FROM users";
        List<UserModel> users = new ArrayList<>();
        try {
            conn = super.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserModel user = new UserModel();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setRoleid(resultSet.getInt("roleid"));
                user.setPhone(resultSet.getString("phone"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static void main(String[] args) {
        iUserDAO userDao = new UserDaoimplData();
        System.out.println(userDao.findByUsername("phatlee"));
    }

    @Override
    public UserModel findByEmail(String email) {
        String sql = "SELECT * FROM users WHERE email = ?";
        try {
            conn = super.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, email);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserModel user = new UserModel();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setRoleid(resultSet.getInt("roleid"));
                user.setPhone(resultSet.getString("phone"));
                user.setFullname(resultSet.getString("fullname"));
                user.setImage(resultSet.getString("image"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public UserModel findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try {
            conn = super.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, username);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserModel user = new UserModel();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setEmail(resultSet.getString("email"));
                user.setRoleid(resultSet.getInt("roleid"));
                user.setPhone(resultSet.getString("phone"));
                user.setFullname(resultSet.getString("fullname"));
                return user;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean insert(UserModel user) {
        String sql = "INSERT INTO users(username, password, email, roleid, phone, fullname) VALUES(?,?,?,?,?,?)";
        try {
            conn = super.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getRoleid());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getFullname());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean update(UserModel user) {
        String sql = "UPDATE users SET username = ?, password = ?, email = ?, roleid = ?, phone = ?, fullname = ? WHERE id = ?";
        try {
            conn = super.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getRoleid());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getFullname());
            preparedStatement.setInt(7, user.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean insertWithImage(UserModel user) {
        String sql = "INSERT INTO users(username, password, email, roleid, phone, fullname, image) VALUES(?,?,?,?,?,?,?)";
        try {
            conn = super.getDatabaseConnection();
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setInt(4, user.getRoleid());
            preparedStatement.setString(5, user.getPhone());
            preparedStatement.setString(6, user.getFullname());
            preparedStatement.setString(7, user.getImage());
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
