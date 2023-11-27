package com.martinkondor.textshare;

import com.martinkondor.textshare.models.TextModel;
import com.martinkondor.textshare.models.UserModel;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class APIController {

    private Logger logger = Logger.getLogger(APIController.class.getName());
    private UserModel sessionUser = null;

    @PostMapping("login")
    public UserModel login(@RequestBody String emailOrUsername, @RequestBody String password) {
        logger.info("login called");
        return null;
    }

    @PostMapping("signup")
    public UserModel signup(@RequestBody UserModel newUser) {
        logger.info("signup called");
        return null;
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
