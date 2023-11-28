package com.martinkondor.textshare;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class APIController {



    private final Logger logger = Logger.getLogger(APIController.class.getName());

    @PostMapping("login")
    public @ResponseBody UserModel login(@RequestBody LoginUserModel loginUserModel) {
        logger.info(loginUserModel.toString());

        // Search for user in database
        // loginUserModel.getEmailOrUsername()

        //UserModel foundUser = userService.getUserByUsername(loginUserModel.getEmailOrUsername());
        // UserModel foundUser = userRespository.findByUsername(loginUserModel.getEmailOrUsername());
        //logger.info(foundUser.toString());

        return null;
    }

    @PostMapping("signup")
    public UserModel signup(@RequestBody UserModel newUser) {
        logger.info(newUser.toString());
        return null;
    }

    @PostMapping("logout")
    public void logout() {
        logger.info("logout is called");
    }

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

    // TODO: Change User settings
}
