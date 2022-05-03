package com.github.maikoncarlos.tarefas.services;

import com.github.maikoncarlos.tarefas.entities.UserEntity;
import com.github.maikoncarlos.tarefas.entities.dto.UserDTO;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

public interface UserService {

    UserEntity createNewUser(@Valid UserDTO userDto, Map<String, String> headers);

	List<UserDTO> getAllUser();

    UserDTO getUserToId(long id);

    UserDTO updateTask(UserDTO userDTO, long id);

    void deleteUser(long id);

}
