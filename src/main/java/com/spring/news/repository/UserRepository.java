package com.spring.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.news.domain.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
    User findByUsername(String username);

}
