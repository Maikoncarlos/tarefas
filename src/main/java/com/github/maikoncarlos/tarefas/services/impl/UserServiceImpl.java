package com.github.maikoncarlos.tarefas.services.impl;

import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.github.maikoncarlos.tarefas.entities.UserEntity;
import com.github.maikoncarlos.tarefas.entities.dto.UserDTO;
import com.github.maikoncarlos.tarefas.entities.mapper.UserMapper;
import com.github.maikoncarlos.tarefas.repositories.UserRepository;
import com.github.maikoncarlos.tarefas.services.UserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	private UserMapper userMapper;

	@Override
	@Transactional
	public UserEntity createNewUser(@Valid UserDTO userDto, Map<String, String> headers) {
		
		//TODO chamar alguma implementacao para autenticacao dessa acao
		
		Optional<UserEntity> user = userRepository.findByEmail(userDto.getEmail());
		
		if(user.isPresent()) {
			throw new RuntimeException("Pessoa ja cadastrada");
		}

		return userRepository.save(userMapper.dtoToEntity(userDto));
		
	}

	@Override
	public UserDTO getAllUsers() {
		return null;
	}

	@Override
	public UserDTO getUserToId(long id) {
		return null;
	}

	@Override
	public UserDTO updateTask(UserDTO userDTO, long id) {
		return null;
	}

	@Override
	public void deleteUser(long id) {

	}


}
