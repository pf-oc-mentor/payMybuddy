package com.myBuddy.Service;

public interface SecurityService {

	boolean isAuthenticated();

	//void autoLogin(String username, String password);

	public String getCurrentUserDetailsUserName();

}
