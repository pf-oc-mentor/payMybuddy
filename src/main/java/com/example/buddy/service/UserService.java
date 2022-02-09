package com.example.buddy.service;

import com.example.buddy.entities.User;

public interface UserService {
	
	public User CreateUser(User user);
	
	public User findByEmail(String email);
	public User findById(Long id);
	public boolean existsByEmailUser(String email);
	
	public User getCurrentUser(String email, String password);

	public  User addBuddy(User owner ,String emailFreinds);

}
