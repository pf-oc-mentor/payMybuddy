package com.example.buddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.buddy.entities.User;
import com.example.buddy.repositories.UserDAO;

@SpringBootApplication
public class PayMyBuddyApplication implements CommandLineRunner {
	@Autowired
	 private UserDAO userRepository;
	
	
	
	public PayMyBuddyApplication() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		SpringApplication.run(PayMyBuddyApplication.class, args);
	}
//	

	@Override
	public void run(String... args) throws Exception {
//		 userRepository.save(new User("user1", "user1@email.com", "123456"));
//		 userRepository.save(new User("user2", "user2@email.com", "123456"));
//		userRepository.save(new User("user3", "user3@email.com", "123456"));
//		userRepository.save(new User("user4", "user4@email.com", "123456"));
//		userRepository.save(new User("user5", "user5@email.com", "123456"));
//		userRepository.save(new User("user6", "user6@email.com", "123456"));
//		userRepository.save(new User("user7", "user7@email.com", "123456"));
//	userRepository.save(new User("user8", "user8@email.com", "123456"));
//		userRepository.save(new User("user9", "user9@email.com", "123456"));
//		userRepository.save(new User("user10", "user10@email.com", "123456"));

	}
	

}