package com.github.maikoncarlos.tarefas.services;

import java.util.Map;

import javax.validation.Valid;

import com.github.maikoncarlos.tarefas.entities.UserEntity;
import com.github.maikoncarlos.tarefas.entities.dto.UserDTO;

public interface UserService {

	UserEntity createNewUser(@Valid UserDTO userDto, Map<String, String> headers);

	UserDTO getAllUsers();

	UserDTO getUserToId(long id);

	UserDTO updateTask(UserDTO userDTO, long id);

	void deleteUser(long id);
}
