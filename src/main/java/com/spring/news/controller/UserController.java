package com.spring.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.spring.news.domain.User;
import com.spring.news.service.UserService;
import org.springframework.ui.Model;
import java.util.List;

@Controller
@RequestMapping("/users") 
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/add") 
    public String addUserForm() {
        return "addUser"; 
    }
    
    @GetMapping("/listUser") 
    public String listUser(Model model) {
    	System.out.println("User user");
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "listUser";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
        userService.addUser(user);
        return "redirect:/users"; 
    }
}
