package com.martinkondor.textshare;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.BindingResult;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class APIController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TextRepository textRepository;
    @Autowired
    private UpvoteRepository upvoteRepository;
    @Autowired
    private DownvoteRepository downvoteRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(16);
    private final Logger logger = Logger.getLogger(APIController.class.getName());

    @PostMapping("login")
    public @ResponseBody BaseResponse login(HttpSession session,
                                            @RequestBody @Valid LoginUserRequest loginUserModel,
                                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return new BaseResponse(0, message);
        }

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
            return new BaseResponse(0, "Incorrect password");
        }

        // Log in the user to a session
        session.setAttribute("user", foundUser);
        return new BaseResponse(1, "Successful login");
    }

    @PostMapping("signup")
    public @ResponseBody BaseResponse signup(HttpSession session,
                                             @RequestBody @Valid UserModel newUser,
                                             BindingResult bindingResult) {

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

        // Log in the user to a session
        session.setAttribute("user", newUser);
        return new BaseResponse(1, "Successful signup");
    }

    @PostMapping("logout")
    public @ResponseBody BaseResponse logout(HttpSession session) {

        // Log out the user of the session
        session.removeAttribute("user");
        return new BaseResponse(1, "Successful logout");
    }

    @GetMapping("user/{username}")
    public @ResponseBody UserModel viewUser(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    @DeleteMapping("user/delete")
    public @ResponseBody BaseResponse deleteUser(@RequestBody Map<String, Long> jsonObject) {
        if (!jsonObject.containsKey("userId")) {
            return new BaseResponse(0, "Invalid JSON input");
        }
        userRepository.deleteById(jsonObject.get("userId"));
        userRepository.flush();

        // Log out the user of the session
        return new BaseResponse(1, "Successful user/delete");
    }

    @PostMapping("write")
    public @ResponseBody BaseResponse write(HttpSession session,
                                           @RequestBody @Valid WriteRequest writeRequest,
                                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String message = bindingResult.getAllErrors().get(0).getDefaultMessage();
            return new BaseResponse(0, message);
        }

        // Check if it's logged in
        if (session.getAttribute("user") == null) {
            return new BaseResponse(0, "Please login for this action");
        }

        UserModel user = (UserModel) session.getAttribute("user");
        String timestamp = TextModel.createTimestamp();
        TextModel newText = new TextModel(user.getId(), timestamp, writeRequest.getContent());

        // Save the new text
        textRepository.save(newText);
        textRepository.flush();
        return new BaseResponse(1, "Successful writing");
    }

    @GetMapping("texts")
    public @ResponseBody List<TextModel> texts(@RequestBody SearchRequest searchRequest) {
        return searchRequest.search(textRepository.findAll());
    }

    @GetMapping("home")
    public @ResponseBody List<TextModelWithVotes> home(@RequestBody SearchRequest searchRequest) {
        List<TextModel> texts = textRepository.findAll();
        ArrayList<TextModelWithVotes> textsWithVotes = new ArrayList<TextModelWithVotes>();

        for (TextModel t : texts) {
            TextModelWithVotes tv = new TextModelWithVotes();
            tv.setId(t.getId());
            tv.setTimestamp(t.getTimestamp());
            tv.setUserId(t.getUserId());
            tv.setContent(t.getContent());

            // Gather the votes for every TextModel
            tv.setDownvotes(downvoteRepository.findAllByTextId(tv.getId()));
            tv.setUpvotes(upvoteRepository.findAllByTextId(tv.getId()));
            textsWithVotes.add(tv);
        }

        return searchRequest.searchWithVotes(textsWithVotes);
    }

    @GetMapping("texts/{username}")
    public @ResponseBody List<TextModel> viewUserTexts(@PathVariable String username) {
        List<TextModel> texts = null;

        // First find the user
        UserModel user = userRepository.findByUsername(username);
        if (user == null) {
            return texts;
        }
        texts = textRepository.findAllByUserId(user.getId());
        return texts;
    }

    @PutMapping("upvote/{textId}")
    public @ResponseBody BaseResponse upvote(HttpSession session, @PathVariable long textId) {
        // Check if it's logged in
        if (session.getAttribute("user") == null) {
            return new BaseResponse(0, "Please login for this action");
        }
        UserModel user = (UserModel) session.getAttribute("user");

        // Find if there is already a vote
        UpvoteModel upvote = upvoteRepository.findByUserIdAndAndTextId(user.getId(), textId);
        DownvoteModel downvote = downvoteRepository.findByUserIdAndAndTextId(user.getId(), textId);
        if (upvote != null) {
            return new BaseResponse(1);
        }
        if (downvote != null) {
            downvoteRepository.deleteById(downvote.getId());
            downvoteRepository.flush();
        }
        // Adding upvote
        UpvoteModel upvoteModel = new UpvoteModel(user.getId(), textId);
        upvoteRepository.save(upvoteModel);
        upvoteRepository.flush();
        return new BaseResponse(1);
    }

    @PutMapping("downvote/{textId}")
    public @ResponseBody BaseResponse downvote(HttpSession session, @PathVariable long textId) {
        // Check if it's logged in
        if (session.getAttribute("user") == null) {
            return new BaseResponse(0, "Please login for this action");
        }
        UserModel user = (UserModel) session.getAttribute("user");

        // Find if there is already a vote
        UpvoteModel upvote = upvoteRepository.findByUserIdAndAndTextId(user.getId(), textId);
        DownvoteModel downvote = downvoteRepository.findByUserIdAndAndTextId(user.getId(), textId);
        if (downvote != null) {
            return new BaseResponse(1);
        }
        if (upvote != null) {
            upvoteRepository.deleteById(upvote.getId());
            upvoteRepository.flush();
        }
        // Adding downvote
        DownvoteModel downvoteModel = new DownvoteModel(user.getId(), textId);
        downvoteRepository.save(downvoteModel);
        downvoteRepository.flush();
        return new BaseResponse(1);
    }

    @DeleteMapping("unvote/{textId}")
    public @ResponseBody BaseResponse unvote(HttpSession session, @PathVariable int textId) {
        // Check if it's logged in
        if (session.getAttribute("user") == null) {
            return new BaseResponse(0, "Please login for this action");
        }
        UserModel user = (UserModel) session.getAttribute("user");

        // Find if there is already a vote
        UpvoteModel upvote = upvoteRepository.findByUserIdAndAndTextId(user.getId(), textId);
        DownvoteModel downvote = downvoteRepository.findByUserIdAndAndTextId(user.getId(), textId);

        if (upvote != null) {
            upvoteRepository.deleteById(upvote.getId());
        }
        if (downvote != null) {
            downvoteRepository.deleteById(downvote.getId());
        }
        return new BaseResponse(1);
    }
}
