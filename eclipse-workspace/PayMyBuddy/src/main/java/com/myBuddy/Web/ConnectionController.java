package com.myBuddy.Web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myBuddy.Entities.User;
import com.myBuddy.Entities.Dto.UserRegistrationDto;
import com.myBuddy.Service.UserService;

@Controller

public final class ConnectionController {
	Logger logger = LoggerFactory.getLogger(ConnectionController.class);
	@Autowired
	private UserService userService;
	
	
	
	
	@GetMapping("/addNewConnection")
    public String showConnectionForm(Model model) {
		UserRegistrationDto user = new UserRegistrationDto();
		model.addAttribute("user", user);
        return "addNewConnection";
    }   

	@PostMapping("/searchUser")
    public String connectionAdd(@RequestParam String email , Model model) { 
    	logger.info("POST /connection");
    	User user = userService.getCurrentUser();
    	//check connection mail exists in DB:
    	if ( !userService.existsByEmail(email) ) {
    		model.addAttribute("error", "Email Unknown");
    		//model.addAttribute("paged", userService.getCurrentUserConnectionPage(1, 5));
            return "addNewConnection";
        }
    	//Check connection to himself:
    	if ( user.getEmail().equalsIgnoreCase(email) ) {
    		model.addAttribute("error", "You can't add yourself as a connection");
    		//model.addAttribute("paged", userService.getCurrentUserConnectionPage(1, 5));
            return "addNewConnection";
        }
    	
        User newConnection = userService.findByEmail(email);
    	user.getConnections().add(newConnection);
    	userService.update(user);

    	return "registration";
    }   

    @PostMapping("/connectionDelete")
    public String connectionDelete(@RequestParam Long id) { 
    	logger.info("POST /connectionDelete");
    	User user = userService.getCurrentUser();
    	user.getConnections().removeIf(connectionUser -> (connectionUser.getId().equals(id)) );
    	userService.update(user);
        
        return "redirect:/connection";
    }
    
  

}
