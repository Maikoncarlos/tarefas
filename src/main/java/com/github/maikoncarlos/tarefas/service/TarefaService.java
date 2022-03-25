package com.github.maikoncarlos.tarefas.service;

import com.github.maikoncarlos.tarefas.entities.Tarefa;
import com.github.maikoncarlos.tarefas.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;


    public ResponseEntity<List<Tarefa>> getAllTasks() {
        List<Tarefa> tarefaList = tarefaRepository.findAll();
        if (tarefaList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<List<Tarefa>>(tarefaList, HttpStatus.OK);
        }
    }

    public ResponseEntity<Tarefa> getTasksToId(long id) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        if (!tarefaOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<Tarefa>(tarefaOptional.get(), HttpStatus.OK);
        }
    }

    public ResponseEntity<Tarefa> createTask(@Valid Tarefa tarefa) {
        return new ResponseEntity<>(tarefaRepository.save(tarefa), HttpStatus.CREATED);
    }

    public ResponseEntity<Tarefa> updateTask(@Valid Tarefa tarefa, long id) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        if (!tarefaOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            tarefa.setId(tarefaOptional.get().getId());
            return new ResponseEntity<Tarefa>(tarefaOptional.get(), HttpStatus.OK);
        }
    }

    public ResponseEntity<?> deleteTask(long id) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        if (!tarefaOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}


