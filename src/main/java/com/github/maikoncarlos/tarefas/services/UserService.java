package com.github.maikoncarlos.tarefas.services;

import com.github.maikoncarlos.tarefas.entities.dto.UserDTO;
import com.github.maikoncarlos.tarefas.entities.dto.ValidDTO;

import java.util.List;

public interface UserService {

    UserDTO createNewUser(UserDTO userDto);

    List<UserDTO> getAllUser();

    UserDTO getUserToId(Long id);

    UserDTO updateTask(UserDTO userDTO, Long id);

    void deleteUser(Long id);

    Boolean validUser(ValidDTO validDTO);
}
