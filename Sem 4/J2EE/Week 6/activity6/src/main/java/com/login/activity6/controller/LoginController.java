package com.login.activity6.controller;

import com.login.activity6.model.User;
import com.login.activity6.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginForm(Model model) {
        return "login";
    }

    @PostMapping("/processLogin")
    public String processLogin(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               Model model) {
        User user = userService.userLogin(username, password);
        if (user != null) {
            model.addAttribute("username", username);
            return "home";
        } else {
            model.addAttribute("errorMessage", "Invalid Username/Password");
            return "login";
        }
    }

    @GetMapping("/register")
    public String signupForm(Model model) {
        return "signup";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username,
                               @RequestParam("password") String password,
                               @RequestParam("gender") String gender,
                               @RequestParam("dob") String dob,
                               Model model) {

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        newUser.setGender(gender);

        try {
            newUser.setDob(LocalDate.parse(dob));
        } catch (Exception e) {
            model.addAttribute("error", "Invalid date format. Please use yyyy-MM-dd.");
            return "signup";
        }

        try {
            userService.addUser(newUser);
            model.addAttribute("message", "Registration successful!");
            return "login";
        } catch (Exception e) {
            model.addAttribute("error", "Registration failed. Please try again.");
            return "signup";
        }
    }
}
