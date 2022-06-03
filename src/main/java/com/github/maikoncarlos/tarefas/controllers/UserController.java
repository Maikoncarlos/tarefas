package com.github.maikoncarlos.tarefas.controllers;

import com.github.maikoncarlos.tarefas.entities.dto.UserDTO;
import com.github.maikoncarlos.tarefas.entities.dto.ValidDTO;
import com.github.maikoncarlos.tarefas.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "Criar Usuário")
    @PostMapping()
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDto) {
        log.info("INICIANDO PROCESSO DE CRIAR USUARIO: ");
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createNewUser(userDto));
    }

    @Operation(summary = "Lista de Todas os Usuários")
    @GetMapping()
    public ResponseEntity<List<UserDTO>> getUsers() {
        log.info("INICIANDO PROCESSO DE BUSCAR DOS USUARIOS");
        return ResponseEntity.ok().body(userService.getAllUser());
    }

    @Operation(summary = "Retorna Somente um Usuário")
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserToId(@PathVariable(value = "id") Long id) {
        log.info("INICIANDO PROCESSO DE BUSCA POR UM USUÁRIO");
        return ResponseEntity.ok().body(userService.getUserToId(id));
    }

    @Operation(summary = "Atualiza um Usuário")
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateTask(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) {
        log.info("INICIANDO PROCESSO DE ATUALIZAÇÃO DO USUÁRIO");
        return ResponseEntity.ok().body(userService.updateTask(userDTO, id));
    }

    @Operation(summary = "Deleta um Usuário por vez")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        log.info("INICIANDO PROCESSO DE DELETAR O USUÁRIO POR ID {}", id);
        userService.deleteUser(id);

    }

    @Operation(summary = "Validar Usuário e Senha ao fazer Login")
    @GetMapping("/valid")
    public ResponseEntity<Boolean> validUser(@Valid @RequestBody ValidDTO validDTO) {
        log.info("INICIANDO PROCESSO DE VALIDAR O LOGIN E SENHA");
        if (Boolean.TRUE.equals(userService.validUser(validDTO))){
            return ResponseEntity.ok().body(false);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(true);
        }
    }
}