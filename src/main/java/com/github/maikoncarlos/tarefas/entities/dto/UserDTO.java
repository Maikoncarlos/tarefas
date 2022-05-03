package com.github.maikoncarlos.tarefas.entities.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserDTO {

	@NotEmpty(message = "email nulo ou vazio")
	@Email(message = "email inválido")
	private String email;
	
	@NotEmpty(message = "nome nulo ou vazio")
	private String name;
}
