package com.github.maikoncarlos.tarefas.entities.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserDTO {

	@NotEmpty
	private String email;
	
	@NotEmpty
	private String name;
}
