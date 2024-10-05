package me.phatlee.demotuan3.entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
@NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r")
public class Role implements Serializable {

    @Id
    @Column(name = "roleid")
    private int roleid;

    @Column(name = "name", length = 100, nullable = false)
    private String name;

    // Default constructor
    public Role() {
    }

    // Getters and Setters
    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
