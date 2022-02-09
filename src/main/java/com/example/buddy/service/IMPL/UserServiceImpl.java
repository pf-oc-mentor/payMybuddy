package com.example.buddy.service.IMPL;

import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.buddy.entities.User;
import com.example.buddy.repositories.UserDAO;
import com.example.buddy.service.UserService;

@Service

public class UserServiceImpl implements UserService {
	  Logger logger =org.slf4j.LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDAO userRepo;

	@Override
	public User CreateUser(User user) {
		return userRepo.save(user);
		
	}


	@Override
	public User findByEmail(String email) {
		return userRepo.findByEmail(email);
		
	}

	@Override
	public User findById(Long id) {
		Optional<User> optUser = userRepo.findById(id);
		 if (optUser.isEmpty()) {
			return null;
		}
		return optUser.get();
	}

	@Override
	public boolean existsByEmailUser(String email) {
		return userRepo.existsByEmail(email);
		
	}

	@Override
	public User getCurrentUser(String email, String password) {
	
		return userRepo.findByEmailAndPassword(email, password);
	}

	@Override
	public User addBuddy(User owner, String email) {
		User newUSer = userRepo.findByEmail(email);
		owner.getFreinds().add(newUSer);
		 return userRepo.save(owner);
	}

	



	
		

	

}
