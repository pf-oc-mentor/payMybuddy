package com.myBuddy.Service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.myBuddy.Entities.User;
import com.myBuddy.Entities.Dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {
	
	public User save(UserRegistrationDto  userRegistrationDto);
	
	public User findByEmail(String email);

	public User findByEmailAndPassword(String email ,String password);
	public void update(User user);
	 public User findById(Long id);
	 public User getCurrentUser();
	 public Boolean existsByEmail(String email);
	

}
