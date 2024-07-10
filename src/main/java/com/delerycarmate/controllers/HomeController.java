package com.delerycarmate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
//controller class
    @GetMapping("/")
    public String showHomePage() {
        return "index";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam("username") String username,
                         @RequestParam(value = "email", required = false) String email,
                         Model model) {
        model.addAttribute("username", username);
        model.addAttribute("email", email);
        return "result";
    }

    @GetMapping("/second")
    public String showSecondPage() {
        return "second";
    }

    @PostMapping("/asyncSignup")
    @ResponseBody
    public String asyncSignup(@RequestParam("username") String username,
                              @RequestParam(value = "email", required = false) String email) {
        return "Username: " + username + ", Email: " + email;
    }

}

