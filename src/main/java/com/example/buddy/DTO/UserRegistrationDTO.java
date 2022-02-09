package com.example.buddy.DTO;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserRegistrationDTO {

	private String firstName;
	private String lastName;
	private String password;
	private String email;

public UserRegistrationDTO() {
	// TODO Auto-generated constructor stub
}

public UserRegistrationDTO(String firstName, String lastName, String password, @Email @NotNull String email) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.password = password;
	this.email = email;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


	

}
