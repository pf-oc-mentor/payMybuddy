package com.myBuddy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.myBuddy.Dao.UserRepository;

@SpringBootApplication
public class PayMyBuddyApplication implements CommandLineRunner {
	@Autowired
   private UserRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(PayMyBuddyApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

	  

	@Override
	public void run(String... args) throws Exception {
//		repository.save(new User("aaa", "aaaa", "a@email.com", "123456"));
		
	}
	     
	
	
	}
	
	
	
