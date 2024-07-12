package com.delerycarmate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // Indicates that this class is a Spring MVC controller
public class HomeController {

    // Handles GET requests to the root URL ("/")
    @GetMapping("/")
    public String showHomePage() {
        // Returns the view name "index" to be rendered for the home page
        return "index";
    }

    // Handles POST requests to the "/signup" URL
    @PostMapping("/signup")
    public String signup(@RequestParam("username") String username, // Binds the "username" request parameter to the method parameter
                         @RequestParam(value = "email", required = false) String email, // Binds the "email" request parameter to the method parameter, not required
                         Model model) {
        // Adds the username to the model
        model.addAttribute("username", username);
        // Adds the email to the model (if provided)
        model.addAttribute("email", email);
        // Returns the view name "result" to be rendered after signup
        return "result";
    }

    // Handles GET requests to the "/second" URL
    @GetMapping("/second")
    public String showSecondPage() {
        // Returns the view name "second" to be rendered for the second page
        return "second";
    }

    // Handles POST requests to the "/asyncSignup" URL
    @PostMapping("/asyncSignup")
    @ResponseBody // Indicates that the return value should be used as the response body
    public String asyncSignup(@RequestParam("username") String username, // Binds the "username" request parameter to the method parameter
                              @RequestParam(value = "email", required = false) String email) { // Binds the "email" request parameter to the method parameter, not required
        // Returns a plain text response with the username and email
        return "Username: " + username + ", Email: " + email;
    }

}


