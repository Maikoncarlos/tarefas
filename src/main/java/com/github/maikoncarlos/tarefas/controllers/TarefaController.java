package com.github.maikoncarlos.tarefas.controllers;

import com.github.maikoncarlos.tarefas.entities.Tarefa;
import com.github.maikoncarlos.tarefas.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping("/tasks")
    public ResponseEntity<List<Tarefa>> getAllTasks(){
        return tarefaService.getAllTasks();
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<Tarefa> getTasksToId(@PathVariable(value = "id") long id){
        return tarefaService.getTasksToId(id);
    }


}
