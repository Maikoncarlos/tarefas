package com.github.maikoncarlos.tarefas.controllers;

import java.net.URI;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.maikoncarlos.tarefas.entities.UserEntity;
import com.github.maikoncarlos.tarefas.entities.dto.TarefaDTO;
import com.github.maikoncarlos.tarefas.entities.dto.UserDto;
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
    public ResponseEntity<UserEntity> createUser(@Valid @RequestBody UserDto userDto, @RequestHeader Map<String, String> headers, UriComponentsBuilder builder) {
        
    	log.info("Class: UserController || Method: createUser");
    	
    	UserEntity user = userService.createNewUser(userDto, headers);
        
    	URI uri = builder.path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

//    @Operation(summary = "Retorna uma Lista de Todas as Tarefas")
//    @GetMapping("/task")
//    public ResponseEntity<List<TarefaDTO>> getAllTasks() {
//        log.info("INICIANDO PROCESSO DE BUSCAR TODAS TAREFAS");
//        return ResponseEntity.ok().body(tarefaService.getAllTasks());
//    }
//
//    @Operation(summary = "Retorna Somente uma Tarefa")
//    @GetMapping("/task/{id}")
//    public ResponseEntity<TarefaDTO> getTasksToId(@PathVariable(value = "id") long id) {
//        log.info("INICIANDO PROCESSO DE BUSCA POR UMA TAREFA");
//        return ResponseEntity.ok().body(tarefaService.getTasksToId(id));
//    }
//
//    @Operation(summary = "Atualiza uma Tarefa")
//    @PutMapping("/task/{id}")
//    public ResponseEntity<TarefaDTO> updateTask(@PathVariable(value = "id") long id, @Valid @RequestBody TarefaDTO tarefaDTO) {
//        log.info("INICIANDO PROCESSO DE ATUALIZAÇÃO DA TAREFA");
//        return ResponseEntity.ok().body(tarefaService.updateTask(tarefaDTO, id));
//    }
//
//    @Operation(summary = "Deleta uma Tarefa por vez")
//    @DeleteMapping("/task/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void deleteTask(@PathVariable(value = "id") long id) {
//        log.info("INICIANDO PROCESSO DE DELETAR A TAREFA POR ID {}", id);
//        tarefaService.deleteTask(id);
//
//    }

}