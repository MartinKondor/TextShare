package com.martinkondor.textshare;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String email;
    private String password;
    private String birthdate;
    private String profileImgUrl;

    public UserModel() {}

    public UserModel(String username, String email, String password, String birthdate, String profileImgUrl) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.profileImgUrl = profileImgUrl;
    }

    public UserModel(int id, String username, String email, String password, String birthdate, String profileImgUrl) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.profileImgUrl = profileImgUrl;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getProfileImgUrl() {
        return profileImgUrl;
    }

    public void setProfileImgUrl(String profileImgUrl) {
        this.profileImgUrl = profileImgUrl;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", profileImgUrl='" + profileImgUrl + '\'' +
                '}';
    }
}
