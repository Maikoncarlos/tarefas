package com.github.maikoncarlos.tarefas.services.impl;

import com.github.maikoncarlos.tarefas.entities.UserEntity;
import com.github.maikoncarlos.tarefas.entities.dto.UserDTO;
import com.github.maikoncarlos.tarefas.entities.mapper.UserMapper;
import com.github.maikoncarlos.tarefas.exception.NotFoundTaskException;
import com.github.maikoncarlos.tarefas.repositories.UserRepository;
import com.github.maikoncarlos.tarefas.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private UserMapper userMapper;

    @Override
    @Transactional
    public UserEntity createNewUser(@Valid UserDTO userDto, Map<String, String> headers) {

        //TODO chamar alguma implementacao para autenticacao dessa acao

        if (userRepository.findByEmail(userDto.getEmail()).isPresent()) {
            throw new RuntimeException("Pessoa ja cadastrada");
        }
        return userRepository.save(userMapper.dtoToEntity(userDto));

    }

    @Override
    public List<UserDTO> getAllUser() {
        List<UserEntity> userEntityList = userRepository.findAll();
        if (!userEntityList.isEmpty()) {
            log.info("SUCESSO - BUSCANDO A LISTA DE USUÁRIOS:");
            return userEntityList.stream()
                    .map(userMapper::entityToDto)
                    .collect(Collectors.toList());
        } else {
            log.error("ERROR - BUSCAR POR TODAS TAREFAS, NÃO EXISTE TAREFAS GRAVADAS");
            throw new NotFoundTaskException("Não tem usuarios cadastrados");
        }
    }

        @Override
        public UserDTO getUserToId ( long id){
            return null;
        }

        @Override
        public UserDTO updateTask (UserDTO userDTO,long id){
            return null;
        }

        @Override
        public void deleteUser ( long id){

        }


    }
