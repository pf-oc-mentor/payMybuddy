package com.myBuddy.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/page_user")
    public String showUserPage() {
        return "page_user";
    }



    
}