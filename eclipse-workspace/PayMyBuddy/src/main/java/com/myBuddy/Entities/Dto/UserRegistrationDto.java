package com.myBuddy.Entities.Dto;

import java.util.Currency;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.myBuddy.Validation.FieldMatch;

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


@FieldMatch.List({
    @FieldMatch(first = "password", second = "confirmPassword", message = "The password fields must match"),
    @FieldMatch(first = "email", second = "confirmEmail", message = "The email fields must match")
})
public class UserRegistrationDto {

    @NotEmpty(message = "Veiller renseigner un nom")
    
    private String firstName;

    @NotEmpty(message = "Veiller renseigner un prenom")
    private String lastName;

    @NotEmpty(message = "Veiller renseigner un mot de passe")
    private String password;

    @NotEmpty(message = "Veiller renseigner un not de passe")
    private String confirmPassword;

    @Email
    @NotEmpty
    private String email;

    @Email
    @NotEmpty
    private String confirmEmail;

    @AssertTrue
    private Boolean terms;

	private String bankAccount;
	private Currency currency;

}
