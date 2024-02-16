package com.example.imdb.requestdto;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserRequestDto {

	@NotBlank(message = "UserName field cannot be blank")
	@NotNull(message = "UserName field cannot be null")
	@Pattern(regexp = "[A-Z]{1}[a-zA-Z\\s]*", message = "userName should Start with capital letter")
	private String userName;

	@NotBlank(message = "userEmail field cannot be blank")
	@NotNull(message = "userEmail cannot be null")
	@Email(regexp = "[a-zA-Z0-9+_.-]+@[g][m][a][i][l]+.[c][o][m]", message = "invalid email--Should be in the extension of '@gmail.com' ")
	private String userEmail;

	@NotBlank(message = "Customer cannot be blank")
	@NotNull(message = "Customer cannot be null")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "8 characters mandatory(1 upperCase,1   	lowerCase,1 special Character,1 number)")
	private String userPassward;

	private LocalDate dateOfBirth;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassward() {
		return userPassward;
	}

	public void setUserPassward(String userPassward) {
		this.userPassward = userPassward;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
