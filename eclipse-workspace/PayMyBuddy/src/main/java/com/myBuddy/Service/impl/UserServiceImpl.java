package com.myBuddy.Service.impl;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myBuddy.Dao.UserRepository;
import com.myBuddy.Entities.Role;
import com.myBuddy.Entities.User;
import com.myBuddy.Entities.Dto.UserRegistrationDto;
import com.myBuddy.Service.UserService;

import lombok.AllArgsConstructor;
  
@Service
@Transactional

public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	 private SecurityServiceImpl securityService;
    
	private BCryptPasswordEncoder passwordEncoder;
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	

	

	 @Override
	    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	        User user = userRepository.findByEmail(email);
	        if (user == null) {
	            throw new UsernameNotFoundException("Invalid username or password.");
	        }
	        return new org.springframework.security.core.userdetails.User(user.getEmail(),
	            user.getPassword(),
	            mapRolesToAuthorities(user.getRoles()));
	    }

	    private Collection < ? extends GrantedAuthority > mapRolesToAuthorities(Collection < Role > roles) {
	        return roles.stream()
	            .map(role -> new SimpleGrantedAuthority(role.getName()))
	            .collect(Collectors.toList());
	    }  

	@Override
	public User save(UserRegistrationDto userRegistrationDto) {
		User user = new User();
		user.setFirstName(userRegistrationDto.getFirstName());
		user.setLastName(userRegistrationDto.getLastName());
		user.setEmail(userRegistrationDto.getEmail());
		
		user.setPassword(passwordEncoder.encode(userRegistrationDto.getPassword()));
		
		user.setRoles(Arrays.asList(new Role("ROLE_USER")));  
		return userRepository.save(user);
	}

	@Override
	public User findByEmail(String email) {

		return userRepository.findByEmail(email);
	}

	@Override
	public User findByEmailAndPassword(String email ,String password) {
		// TODO Auto-generated method stub
		return userRepository.findByEmailAndPassword(email,password) ;
	}

	@Override
	public User findById(Long id) {
		logger.debug("Calling findById({})", id);
		Optional<User> optuser = userRepository.findById(id);
		if (optuser.isEmpty()) {
			return null;
		}
				
		return optuser.get();
	}

	@Override
	public void update(User user) {
		logger.debug("Calling update(User user)");		
		userRepository.save(user);
	}


		@Override
		public User getCurrentUser() {
			return userRepository.findByEmail(securityService.getCurrentUserDetailsUserName());
		}
	@Override
	public Boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.existsByEmail(email);
	}

}
