package com.example.buddy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.buddy.entities.User;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

	public User findByEmail(String email);

	//@Query("SELECT CASE " + "WHEN COUNT(u)>0 THEN true " + " ELSE false end" + "FROM User u" + "WHERE u.email= :email")
	public boolean existsByEmail(@Param("email") String email);  

	public User findByEmailAndPassword(String email, String password);
}
