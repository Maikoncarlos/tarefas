package com.github.maikoncarlos.tarefas.entities.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UserDTO {

    @NotBlank(message = "digite o nome")
    private String name;

    @NotBlank(message = "digite o email")
    @Email(message = "dados inválido")
    private String login;

    @NotBlank(message = "digite a senha")
    private String password;
}