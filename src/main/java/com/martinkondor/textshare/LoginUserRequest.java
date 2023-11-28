package com.martinkondor.textshare;

public class LoginUserRequest {
    private String emailOrUsername;
    private String password;

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
