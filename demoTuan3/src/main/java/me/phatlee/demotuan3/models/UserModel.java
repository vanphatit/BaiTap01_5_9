package me.phatlee.demotuan3.models;

import java.io.Serializable;

public class UserModel implements Serializable {
    private int id;
    private String username;
    private String password;
    private String email;
    private int roleid;
    private String phone;

    public UserModel() {
    }

    public UserModel(int id, String username, String password, String email, int roleid, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.roleid = roleid;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roleid=" + roleid +
                ", phone='" + phone + '\'' +
                '}';
    }
}
