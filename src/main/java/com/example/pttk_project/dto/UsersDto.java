package com.example.pttk_project.dto;


public class UsersDto {

    String email;

    String password;

    public UsersDto(String email, String password){
        this.email = email;
        this.password = password;
    }
    UsersDto(){
        this.email = "";
        this.password = "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
