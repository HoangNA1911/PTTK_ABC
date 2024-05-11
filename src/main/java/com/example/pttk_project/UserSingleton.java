package com.example.pttk_project;

public class UserSingleton {
    private static UserSingleton instance;
    private String username;
    private String password;
    private boolean isUngVien;

    public boolean getIsUngVien() {
        return isUngVien;
    }

    public void setUngVien(boolean ungVien) {
        isUngVien = ungVien;
    }

    private UserSingleton() {
        username = null;
        password = null;
        isUngVien = false;
    }

    public static synchronized UserSingleton getInstance() {
        if (instance == null) {
            instance = new UserSingleton();
        }
        return instance;
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
}
