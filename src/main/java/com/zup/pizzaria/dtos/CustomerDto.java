package com.zup.pizzaria.dtos;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CustomerDto {
@NotNull(message = "Nome é obrigatório")
	private String name;
@NotNull(message = "Email é obrigatório")
@Email(message = "O formato do e-mail é user@email.com")
	private String email;
@NotNull(message = "O número de telefone é obrigatório")
@Pattern(regexp = "^\\d{8}$", message = "O número de telefone deve conter 8 dígitos")
	private String phone;

	public CustomerDto(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
