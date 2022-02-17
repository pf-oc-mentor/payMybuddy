package com.example.buddy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.buddy.entities.User;
import com.example.buddy.repositories.UserDAO;
import com.example.buddy.service.UserService;

@SpringBootTest
class PayMyBuddyApplicationTests {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private UserService userS;
    
    @Test
    void contextLoads() {
    }

    @Test
    //@Disabled
    public void CreateAndGetUsUser() {
        User u11 = new User("Sekou", "sekou@exemple.com", "12345");
        userDAO.save(u11);

        User u12 = userDAO.findByEmail("sekou@exemple.com");

        assertThat(u12.getFirstName()).isEqualTo(u11.getFirstName());

    }

    @Test
    //@Disabled
    public void createAndAddFriend() {
        User c = new User("user11000", "user11000@email.com", "12345");
        userDAO.save(c);
        User c1 = new User("user12000", "user12000@email.com", "12345");;
        c1.getFreinds().add(c);
        userDAO.save(c1);
        User c2 = userDAO.findByEmail("user12000@email.com");
        assertThat(c2.getFreinds().size()).isEqualTo(c1.getFreinds().size());
        
        userS.addBuddy(c, "user12000@email.com");

    }
}
