package com.example.buddy.DTO;

import java.math.BigDecimal;
import java.util.Currency;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class TransactionDTO {
	@NotNull
  private Long userDestinationId;
	

	@NotNull
	@Positive
	@Max(999999999)
  private BigDecimal amount;
	@NotNull
  private Currency currency;
}
