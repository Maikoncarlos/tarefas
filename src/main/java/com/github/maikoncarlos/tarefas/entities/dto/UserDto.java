package com.github.maikoncarlos.tarefas.entities.dto;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class UserDto {

	@NotEmpty
	private String email;
	
	@NotEmpty
	private String name;
}
