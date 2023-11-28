package com.martinkondor.textshare;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;

import java.util.logging.Logger;

@RestController
public class APIController {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(16);

    private final Logger logger = Logger.getLogger(APIController.class.getName());

    @PostMapping("login")
    public @ResponseBody BaseResponse login(@RequestBody LoginUserRequest loginUserModel) {
        UserModel foundUser;

        // Found by Username first
        foundUser = userRepository.findByUsername(loginUserModel.getEmailOrUsername());

        // Found by Email instead
        if (foundUser == null) foundUser = userRepository.findByEmail(loginUserModel.getEmailOrUsername());

        if (foundUser == null) {
            return new BaseResponse(0, "User not found");
        }

        // Check password
        boolean passwordIsCorrect = passwordEncoder.matches(loginUserModel.getPassword(), foundUser.getPassword());
        if (!passwordIsCorrect) {
            return new BaseResponse(1, "Incorrect password");
        }

        // TODO: Log in the user to a session
        return new BaseResponse(1, "Successful login");
    }

    @PostMapping("signup")
    public @ResponseBody BaseResponse signup(@RequestBody @Valid UserModel newUser, BindingResult bindingResult) {
        if (userRepository.findByEmail(newUser.getEmail()) != null) {
            return new BaseResponse(0, "The given email is already in use");
        }
        if (userRepository.findByUsername(newUser.getUsername()) != null) {
            return new BaseResponse(0, "The given username is already in use");
        }

        // Validate user data
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return new BaseResponse(0, message);
        }

        // Encrypt password
        String encryptedPassword = passwordEncoder.encode(newUser.getPassword());
        newUser.setPassword(encryptedPassword);

        // Save the user to the database
        userRepository.save(newUser);
        userRepository.flush();

        // TODO: Log in the user to a session
        return new BaseResponse(1, "Successful signup");
    }

    @PostMapping("logout")
    public @ResponseBody BaseResponse logout() {
        // TODO: Log out the user of the session
        return new BaseResponse(0);
    }

    @GetMapping("user/{username}")
    public @ResponseBody UserModel viewUser(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    @DeleteMapping("user/delete")
    public @ResponseBody BaseResponse deleteUser(@RequestBody long id) {
        userRepository.deleteById(id);
        userRepository.flush();

        // TODO: Log out the user of the session
        return new BaseResponse(1);
    }

    /*
    @GetMapping("home")
    public @ResponseBody String home() {
        logger.info("home is called");
        String message = "Here is a message";
        return message;
    }

    @PutMapping("posting")
    public void posting(@RequestBody TextModel newText) {
        logger.info("postText called");
    }

    @PutMapping("upvote")
    public void upvote(@RequestBody int textId) {
        logger.info("upvote called");
    }

    @PutMapping("downvote")
    public void downvote(@RequestBody int textId) {
        logger.info("downvote called");
    }

    @DeleteMapping("unvote")
    public void unvote(@RequestBody int textId) {
        logger.info("unvote called");
    }

    @GetMapping("text/{textId}")
    public TextModel getText(@PathVariable(value="textId") int textId) {
        logger.info("getText called");
        return null;
    }

    @GetMapping("user/{userId}")
    public UserModel getUser(@PathVariable(value="userId") int userId) {
        logger.info("getUser called");
        return null;
    }
     */
    // TODO: Change User settings
}
