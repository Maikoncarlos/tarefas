package com.github.maikoncarlos.tarefas.services;

import java.util.Map;

import javax.validation.Valid;

import com.github.maikoncarlos.tarefas.entities.UserEntity;
import com.github.maikoncarlos.tarefas.entities.dto.UserDto;

public interface UserService {

	UserEntity createNewUser(@Valid UserDto userDto, Map<String, String> headers);

}
