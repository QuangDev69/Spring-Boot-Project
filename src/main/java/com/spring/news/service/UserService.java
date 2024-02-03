package com.spring.news.service;

import com.spring.news.domain.User;
import com.spring.news.dto.UserDto;

import java.util.List;

public interface UserService {
	void addUser(User user);

	public List<User> getAllUsers();

    void registerUser(UserDto userDto);
}
