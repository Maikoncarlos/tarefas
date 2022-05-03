package com.github.maikoncarlos.tarefas.controllers;

import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.github.maikoncarlos.tarefas.entities.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.maikoncarlos.tarefas.entities.UserEntity;
import com.github.maikoncarlos.tarefas.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    
    @Operation(summary = "Create user")
    @PostMapping()
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserDTO userDto, @RequestHeader Map<String, String> headers, UriComponentsBuilder builder) {
        
    	log.info("Class: UserController || Method: createUser");
    	
    	UserEntity user = userService.createNewUser(userDto, headers);
        
    	URI uri = builder.path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

    @Operation(summary = "Lista de Todas os Usuários")
    @GetMapping()
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        log.info("INICIANDO PROCESSO DE BUSCAR DOS USUARIOS");
        return ResponseEntity.ok().body(userService.getAllUser());
    }

    @Operation(summary = "Retorna Somente um Usuário")
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserToId(@PathVariable(value = "id") long id) {
        log.info("INICIANDO PROCESSO DE BUSCA POR UM USUÁRIO");
        return ResponseEntity.ok().body(userService.getUserToId(id));
    }

    @Operation(summary = "Atualiza um Usuário")
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateTask(@PathVariable(value = "id") long id, @Valid @RequestBody UserDTO userDTO) {
        log.info("INICIANDO PROCESSO DE ATUALIZAÇÃO DO USUÁRIO");
        return ResponseEntity.ok().body(userService.updateTask(userDTO, id));
    }

    @Operation(summary = "Deleta um Usuário por vez")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable(value = "id") long id) {
        log.info("INICIANDO PROCESSO DE DELETAR O USUÁRIO POR ID {}", id);
        userService.deleteUser(id);

    }

}