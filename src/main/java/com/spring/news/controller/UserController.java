package com.spring.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public String userList(Pageable pageable, Model model) {
        pageable = PageRequest.of(pageable.getPageNumber(), 10);
        Page<User> usersPage = userService.findAll(pageable);
        System.out.println("SIZE: "+usersPage.getSize());
        model.addAttribute("usersPage", usersPage);
        return "listUser";
    }
    @PostMapping("/add")
    public String addUser(@ModelAttribute User user) {
    	
        userService.addUser(user);
        
        return "redirect:/users"; 
    }
    
    
    @GetMapping("/{userId}")
    public String showUserDetail(@PathVariable("userId") int userId, Model model) {
    	
        User user = userService.getUserById(userId);

        if (user == null) {

            return "error404"; 
        }

        model.addAttribute("user", user);
        return "userDetail"; 
    }
    
    @PostMapping("/{userId}/delete")
    public String deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUserById(userId);

    	return "redirect:/users/listUser";
    }
}
