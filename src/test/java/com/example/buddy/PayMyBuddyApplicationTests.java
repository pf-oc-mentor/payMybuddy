package com.example.buddy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.buddy.entities.User;
import com.example.buddy.repositories.UserDAO;

@SpringBootTest
class PayMyBuddyApplicationTests {
@Autowired
private UserDAO userDAO;

	@Test
	void contextLoads() {
	}


	@Test
	//@Disabled
	public void CreateAndGetUsUser() {
		User u11 = new User("user11", "u11@email.com", "12345");
		userDAO.save(u11);

		User u12 = userDAO.findByEmail("u11@email.com");
		
		assertThat(u12.getFirstName()).isEqualTo(u11.getFirstName());
		
	}
	 @Test
	 //@Disabled
	    public void createAndAddFriend() {
        User c = new User("user110", "user110@email.com", "12345");
	        userDAO.save(c);
        User c1 = new User("user120", "user120@email.com", "12345");;  
	        c1.getFreinds().add(c);
	        userDAO.save(c1);
	        User c2 = userDAO.findByEmail("user120@email.com");
        assertThat(c2.getFreinds().size()).isEqualTo(c1.getFreinds().size());

}
}
