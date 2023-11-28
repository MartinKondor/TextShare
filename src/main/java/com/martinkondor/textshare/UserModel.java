package com.martinkondor.textshare;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name = "user")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Username cannot be empty")
    @Size(min=5, max=128, message = "The username's size must be between 5 and 128 characters")
    private String username;

    @NotNull(message = "Email cannot be empty")
    @Email(message = "You must give a proper email address")
    @Size(min=5, max=128, message = "The email's size must be between 5 and 128 characters")
    private String email;

    @NotNull(message = "Password cannot be empty")
    @Size(min=5, max=128, message = "The password's size must be between 5 and 128 characters")
    private String password;

    @NotNull(message = "Birthdate cannot be empty")
    @Size(min=10, max=10, message = "The date must be in the following format: YYYY-MM-DD")
    private String birthdate;

    @Size(min = 0, max = 32768, message = "The URL is too long")
    private String profileImgUrl;

    public UserModel() {}

    public UserModel(String username, String email, String password, String birthdate, String profileImgUrl) {
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        this.setBirthdate(birthdate);
        this.setProfileImgUrl(profileImgUrl);
    }

    public UserModel(int id, String username, String email, String password, String birthdate, String profileImgUrl) {
        this.setId(id);
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        this.setBirthdate(birthdate);
        this.setProfileImgUrl(profileImgUrl);
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
