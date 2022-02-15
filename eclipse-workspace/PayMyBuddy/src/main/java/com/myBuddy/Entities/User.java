package com.myBuddy.Entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Currency;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity()
@Table(uniqueConstraints = @UniqueConstraint(columnNames  = "email"))
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String firstName;
	private String lastName;
	private String email;
	private String password;

	private BigDecimal amount;
	private String bankAccount;
	private Currency currency;
	private LocalDateTime inscriptionDate;
	private boolean enabled;

	 @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(
	        name = "users_roles",  
	        joinColumns = @JoinColumn(
	            name = "user_id", referencedColumnName = "id"),
	        inverseJoinColumns = @JoinColumn(
	            name = "role_id", referencedColumnName = "id"))
	    private Collection < Role > roles;

	@ManyToMany
	@JoinTable(name = "users_connections", 
	           joinColumns = @JoinColumn(name = "user_id"),
	           inverseJoinColumns = @JoinColumn(name = "connection_id"))
	private Collection<User> connections;
  
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private Collection<BankTransaction> bankTransactions;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "userSource", cascade = CascadeType.ALL)
	private Collection<UserTransaction> userTransaction;

	public User(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	
	

}
