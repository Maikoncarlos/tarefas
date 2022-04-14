package com.github.maikoncarlos.tarefas.controllers;

import com.github.maikoncarlos.tarefas.controllers.dto.TarefaDTO;
import com.github.maikoncarlos.tarefas.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Operation(summary = "Cria uma Tarefa Nova")
    @PostMapping("/task")
    public ResponseEntity<TarefaDTO> createTask(@RequestBody @Valid TarefaDTO tarefaDTO) {
        log.info("INICIANDO PROCESSO DE GRAVAÇÃO DE TAREFAS");
        return tarefaService.createTask(tarefaDTO);
    }

    @Operation(summary = "Retorna uma Lista de Todas as Tarefas")
    @GetMapping("/task")
    public ResponseEntity<List<TarefaDTO>> getAllTasks() {
        log.info("INICIANDO PROCESSO DE BUSCAR TODAS TAREFAS");
        return tarefaService.getAllTasks();
    }

    @Operation(summary = "Retorna Somente uma Tarefa buscando pelo numero do ID")
    @GetMapping("/task/{id}")
    public ResponseEntity<TarefaDTO> getTasksToId(@PathVariable(value = "id") long id) {
        log.info("INICIANDO PROCESSO DE BUSCA POR UMA TAREFA");
        return tarefaService.getTasksToId(id);
    }

    @Operation(summary = "Atualiza uma Tarefa")
    @PutMapping("/task/{id}")
    public ResponseEntity<TarefaDTO> updateTask(@PathVariable(value = "id") long id, @RequestBody @Valid TarefaDTO tarefaDTO) {
        log.info("INICIANDO PROCESSO DE ATUALIZAÇÃO DA TAREFA");
        return tarefaService.updateTask(tarefaDTO, id);
    }

    @Operation(summary = "Deleta uma Tarefa")
    @DeleteMapping("/task/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable(value = "id") long id) {
        log.info("INICIANDO PROCESSO DE DELETAR DE TAREFA POR ID {}", id);
        return tarefaService.deleteTask(id);
    }

}