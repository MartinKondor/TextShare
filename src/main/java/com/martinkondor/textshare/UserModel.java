package com.martinkondor.textshare;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@ToString
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    public UserModel(String username, String email, String password, String birthdate, String profileImgUrl) {
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        this.setBirthdate(birthdate);
        this.setProfileImgUrl(profileImgUrl);
    }

    public UserModel(long id, String username, String email, String password, String birthdate, String profileImgUrl) {
        this.setId(id);
        this.setUsername(username);
        this.setEmail(email);
        this.setPassword(password);
        this.setBirthdate(birthdate);
        this.setProfileImgUrl(profileImgUrl);
    }
}
