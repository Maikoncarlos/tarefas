package com.github.maikoncarlos.tarefas.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Table(name = "TB_USUARIOS")
@Entity
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String name;

    @NotEmpty(message = "digite o login")
    @Column(name = "email", nullable = false)
    @Email(message = "formato inválido")
    private String login;

    @Column(name = "senha", nullable = false)
    private String password;
}
