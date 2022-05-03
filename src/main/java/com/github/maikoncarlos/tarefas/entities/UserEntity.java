package com.github.maikoncarlos.tarefas.entities;

import java.util.UUID;

import javax.persistence.*;

import lombok.Data;

@Table(name = "TB_USUARIOS")
@Entity
@Data
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "email", nullable = false)
	private String email;
}
