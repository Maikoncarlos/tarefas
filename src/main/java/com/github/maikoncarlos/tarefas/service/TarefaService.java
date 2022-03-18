package com.github.maikoncarlos.tarefas.service;

import com.github.maikoncarlos.tarefas.entities.Tarefa;
import com.github.maikoncarlos.tarefas.entities.repositories.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;


    public ResponseEntity<List<Tarefa>> getAllTasks(){
        List<Tarefa> tarefaList = tarefaRepository.findAll();
        if(tarefaList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<List<Tarefa>>(HttpStatus.CREATED);
        }
    }
    public ResponseEntity<Tarefa> getTasksToId(long id){
        Optional<Tarefa> tafefaOptional = tarefaRepository.findById(id);
            if(!tafefaOptional.isPresent()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }else{
                return new ResponseEntity<Tarefa>(tafefaOptional.get(), HttpStatus.OK);
            }
        }
    }

