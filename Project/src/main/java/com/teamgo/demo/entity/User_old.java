package com.teamgo.demo.entity;

import io.swagger.annotations.ApiModel;

@ApiModel("用户实体")
public class User_old {
    private int id;

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

    public String getHashedPassword() {
        return password;
    }

    public void setHashedPassword(String password) {
        this.password = password;
    }

    private String username;
    private String password;

    @Override
    public String toString() {
        return "User {" + "id=" + id + ", " + "username=" + username + ", password=" + password + " }";
    }
}
