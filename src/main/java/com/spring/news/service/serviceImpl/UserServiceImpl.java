package com.spring.news.service.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.news.domain.User;
import com.spring.news.dto.UserDto;
import com.spring.news.repository.UserRepository;
import com.spring.news.service.UserService;

import jakarta.transaction.Transactional;
import java.util.List;

@Service

public class UserServiceImpl implements UserService {
	
    private  UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    @Transactional
    public void addUser(User user) {
        userRepository.save(user);
    }
    

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
    
    @Override
    public void registerUser(UserDto userDto) {

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        userRepository.save(user);
    }

}
