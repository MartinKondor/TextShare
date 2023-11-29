package com.martinkondor.textshare;

import jakarta.validation.constraints.NotNull;

public class LoginUserRequest {
    @NotNull
    private String emailOrUsername;
    @NotNull
    private String password;

    public LoginUserRequest() {}

    public LoginUserRequest(String emailOrUsername, String password) {
        this.emailOrUsername = emailOrUsername;
        this.password = password;
    }

    public String getEmailOrUsername() {
        return emailOrUsername;
    }

    public void setEmailOrUsername(String emailOrUsername) {
        this.emailOrUsername = emailOrUsername;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginUserModel{" +
                "emailOrUsername='" + emailOrUsername + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
