package com.example.buddy.web;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.buddy.entities.User;
import com.example.buddy.service.UserService;

@Controller
public class UserController {

    Logger logger = org.slf4j.LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;


    @GetMapping("/connection")
    public String connection(Model model) {
        // model.addAttribute("paged", attributeValue);
        return "relation";

    }

    @PostMapping("/addConnection")
    public String connectionAdd(@RequestParam String email, Model model) {
        logger.info("post connection "+email);
        
        User owner = userService.findByEmail("sekou@exemple.com");

        if (!userService.existsByEmailUser(email)) {
            model.addAttribute("errorMail", "Email unknown");
            return "relation";
        }

//		if (owner.getEmail().equalsIgnoreCase(email)) {
//			model.addAttribute("errorUser", "you can't add yourself as a connection");
//			return "relation";
//		}
        User userAdd = userService.addBuddy(owner, email);
        model.addAttribute("userAdd", userAdd);
        return "relation";

    }

}
