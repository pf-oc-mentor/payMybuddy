package com.myBuddy.Entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Currency;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @EqualsAndHashCode @ToString @NoArgsConstructor @AllArgsConstructor
@Entity
public class BankTransaction {
	@Id @GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id" ,nullable = false )
	private User user;
	
	private String bankAccount;
	private BigDecimal amount;
	private LocalDateTime dateTime;
	private Currency currency;
	
}
