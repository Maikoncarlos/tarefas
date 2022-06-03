package com.github.maikoncarlos.tarefas.controllers;

import com.github.maikoncarlos.tarefas.entities.dto.TarefaDTO;
import com.github.maikoncarlos.tarefas.services.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Operation(summary = "Cria uma TarefaEntity Nova")
    @PostMapping("/task")
    public ResponseEntity<TarefaDTO> createTask(@Valid @RequestBody TarefaDTO tarefaDTO) {
        log.info("INICIANDO PROCESSO DE GRAVAÇÃO DE TAREFAS");
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.createTask(tarefaDTO));
    }

    @Operation(summary = "Retorna uma Lista de Todas as Tarefas")
    @GetMapping("/task")
    public ResponseEntity<List<TarefaDTO>> getAllTasks() {
        log.info("INICIANDO PROCESSO DE BUSCAR TODAS TAREFAS");
        return ResponseEntity.ok().body(tarefaService.getAllTasks());
    }

    @Operation(summary = "Retorna Somente uma TarefaEntity")
    @GetMapping("/task/{id}")
    public ResponseEntity<TarefaDTO> getTasksToId(@PathVariable(value = "id") Long id) {
        log.info("INICIANDO PROCESSO DE BUSCA POR UMA TAREFA");
        return ResponseEntity.ok().body(tarefaService.getTasksToId(id));
    }

    @Operation(summary = "Atualiza uma TarefaEntity")
    @PutMapping("/task/{id}")
    public ResponseEntity<TarefaDTO> updateTask(@PathVariable(value = "id") Long id, @Valid @RequestBody TarefaDTO tarefaDTO) {
        log.info("INICIANDO PROCESSO DE ATUALIZAÇÃO DA TAREFA");
        return ResponseEntity.ok().body(tarefaService.updateTask(tarefaDTO, id));
    }

    @Operation(summary = "Deleta uma TarefaEntity por vez")
    @DeleteMapping("/task/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTask(@PathVariable(value = "id") Long id) {
        log.info("INICIANDO PROCESSO DE DELETAR A TAREFA POR ID {}", id);
        tarefaService.deleteTask(id);

    }

}