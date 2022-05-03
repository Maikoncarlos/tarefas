package com.github.maikoncarlos.tarefas.entities.mapper;

import com.github.maikoncarlos.tarefas.entities.dto.UserDTO;
import org.mapstruct.Mapper;

import com.github.maikoncarlos.tarefas.entities.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserEntity dtoToEntity(UserDTO dto);

	UserDTO entityToDto(UserEntity entity);
}
