package com.github.maikoncarlos.tarefas.entities.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class ValidDTO {

    @NotEmpty(message = "digite o email")
    @Email(message = "dados inválido")
    private String login;

    @NotEmpty(message = "digite a senha")
    private String password;

}