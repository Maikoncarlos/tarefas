package com.github.maikoncarlos.tarefas.controllers;

import com.github.maikoncarlos.tarefas.entities.Tarefa;
import com.github.maikoncarlos.tarefas.service.TarefaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Operation(summary = "Retorna Todas as Tarefas")
    @GetMapping("/task")
    public ResponseEntity<List<Tarefa>> getAllTasks() {
        return tarefaService.getAllTasks();
    }

    @Operation(summary = "Retorna Somente uma Tarefa buscando pelo numero do ID")
    @GetMapping("/task/{id}")
    public ResponseEntity<Tarefa> getTasksToId(@PathVariable(value = "id") long id) {
        return tarefaService.getTasksToId(id);
    }

    @Operation(summary = "Cria uma Tarefa Nova")
    @PostMapping("/task")
    public ResponseEntity<Tarefa> createTask(@RequestBody @Valid Tarefa tarefa) {
        return tarefaService.createTask(tarefa);
    }

    @Operation(summary = "Atualiza uma Tarefa")
    @PutMapping("/task/{id}")
    public ResponseEntity<Tarefa> updateTask(@PathVariable(value = "id") long id, @RequestBody @Valid Tarefa tarefa) {
        return tarefaService.updateTask(tarefa, id);
    }

    @Operation(summary = "Deleta uma Tarefa")
    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> deleteTask(@PathVariable(value = "id") long id) {
        return tarefaService.deleteTask(id);
    }


}
