package com.spring.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.spring.news.dto.UserDto;
import com.spring.news.service.UserService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private UserService userService;


	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	
	  @GetMapping("/register")
	    public String showRegistrationForm(Model model) {
	        // Hiển thị form đăng ký
	        model.addAttribute("userDto", new UserDto());
	        return "registerUser"; // Tên của trang JSP hoặc Thymeleaf template
	    }

	    @PostMapping("/register")
	    public String processRegistrationForm(@ModelAttribute("userDto") @Valid UserDto userDto, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	            return "rregisterUser"; // Trả về trang đăng ký nếu có lỗi dữ liệu
	        }

	        userService.registerUser(userDto);
	        return "redirect:/login"; // Chuyển hướng đến trang đăng nhập sau khi đăng ký thành công
	    }

}
