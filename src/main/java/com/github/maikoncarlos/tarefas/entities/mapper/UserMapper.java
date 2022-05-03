package com.github.maikoncarlos.tarefas.entities.mapper;

import org.mapstruct.Mapper;

import com.github.maikoncarlos.tarefas.entities.UserEntity;
import com.github.maikoncarlos.tarefas.entities.dto.UserDto;

@Mapper(componentModel = "spring")
public interface UserMapper {

	UserEntity dtoToEntity(UserDto dto);

	UserDto entityToDto(UserEntity entity);
}
