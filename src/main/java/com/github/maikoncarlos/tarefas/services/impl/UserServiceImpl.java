package com.github.maikoncarlos.tarefas.services.impl;

import com.github.maikoncarlos.tarefas.entities.UserEntity;
import com.github.maikoncarlos.tarefas.entities.dto.UserDTO;
import com.github.maikoncarlos.tarefas.entities.dto.ValidDTO;
import com.github.maikoncarlos.tarefas.entities.mapper.UserMapper;
import com.github.maikoncarlos.tarefas.exception.NotFoundTaskException;
import com.github.maikoncarlos.tarefas.exception.UserRegisteredException;
import com.github.maikoncarlos.tarefas.repositories.UserRepository;
import com.github.maikoncarlos.tarefas.services.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    @Transactional
    public UserDTO createNewUser(@Valid UserDTO userDto) {
        if (validLoginRegistered(userDto.getLogin())) {
            log.error("ERROR - USUÁRIO JÁ CADASTRADO NA BD");
            throw new UserRegisteredException("Usuário já registrado");
        } else {
            UserEntity user = userMapper.dtoToEntity(userDto);
            user.setPassword(encoder.encode(userDto.getPassword()));
            log.debug("SUCESSO - USUÁRIO CRIADO: " + user);
            return userMapper.entityToDto(userRepository.save(user));
        }

    }

    private boolean validLoginRegistered(String login) {
        log.info("VALIDANDO LOGIN NA BD");
        Boolean user = userRepository.findByLogin(login).isPresent();
        log.info("USER: " + user);
        return user;
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
            log.error("ERROR - BUSCAR POR TODOS USUÁRIO, NÃO EXISTE USUÁRIOS NA BD");
            throw new NotFoundTaskException("Não tem usuários cadastrados");
        }
    }

    @Override
    public UserDTO getUserToId(Long id) {
        return null;
    }

    @Override
    public UserDTO updateTask(UserDTO userDTO, Long id) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.delete(userRepository.findById(id).get());
    }

    @Override
    public Boolean validUser(ValidDTO validDTO) {
        log.info("VALIDANDO LOGIN E SENHA");
        UserEntity optUser = userRepository.findByLogin(validDTO.getLogin()).orElseThrow(() -> new UserRegisteredException("Login ou Senha incorretas!"));
        log.info("OPTUSER" + optUser);
        boolean valid = encoder.matches(validDTO.getPassword(), optUser.getPassword());
        log.info("VALID " + valid);
        return !valid;
    }

}