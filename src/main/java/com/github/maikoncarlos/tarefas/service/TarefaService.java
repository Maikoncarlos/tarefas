package com.github.maikoncarlos.tarefas.service;

import com.github.maikoncarlos.tarefas.controllers.dto.TarefaDTO;
import com.github.maikoncarlos.tarefas.entities.Tarefa;
import com.github.maikoncarlos.tarefas.exception.NaoTemTarefaException;
import com.github.maikoncarlos.tarefas.repositories.TarefaRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TarefaService {

//    private static final Logger log = LoggerFactory.getLogger(TarefaService.class);

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ModelMapper modelMapper;


    public ResponseEntity<TarefaDTO> createTask(TarefaDTO tarefaDTO) {
        return new ResponseEntity<>(toTarefaDTO(
                tarefaRepository.save(toTarefa(tarefaDTO))), HttpStatus.CREATED);
    }

    public ResponseEntity<List<TarefaDTO>> getAllTasks() {
        List<Tarefa> tarefaList = tarefaRepository.findAll();
        if (!tarefaList.isEmpty()) {
            return new ResponseEntity<List<TarefaDTO>>(
                    tarefaList.stream()
                            .map(this::toTarefaDTO)
                            .collect(Collectors.toList()), HttpStatus.OK);
        } else {
            log.info("BUSCA POR TODAS TAREFAS, ERROR NÃO EXISTE TAREFAS GRAVADAS");
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Não tem nenhuma tarefa em BD");

        }
    }

    public ResponseEntity<TarefaDTO> getTasksToId(long id){
        Tarefa tarefa = tarefaRepository.findById(id).get();
        if (tarefa != null) {
            return new ResponseEntity<>(toTarefaDTO(tarefa), HttpStatus.OK);
        } else {
            log.info("BUSCA POR TAREFA PELO ID, ERROR NO ID: {}", id);
            throw new NaoTemTarefaException("Não tem nenhuma tarefa em BD");
        }
    }

    public ResponseEntity<TarefaDTO> updateTask(TarefaDTO tarefaDTO, long id) {
        Tarefa tarefa = tarefaRepository.findById(id).get();
        if (tarefa != null) {
            return new ResponseEntity<>(toTarefaDTO(
                    tarefaRepository.save(toTarefa(tarefaDTO))), HttpStatus.OK);
        } else {
            log.info("ATUALIZAR TAREFA PELO ID, ERROR NO ID: {}", tarefa.getId());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    public ResponseEntity<String> deleteTask(long id) {
        Tarefa tarefa = tarefaRepository.findById(id).get();
        if (tarefa != null) {
            tarefaRepository.delete(tarefa);
            return new ResponseEntity<>("deletado com sucesso", HttpStatus.OK);
        } else {
            log.info("DELETAR TAREFA PELO ID, ERROR NO ID: {}", id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
    }

    private TarefaDTO toTarefaDTO(Tarefa tarefa) {
        return modelMapper.map(tarefa, TarefaDTO.class);
    }

    private Tarefa toTarefa(TarefaDTO tarefaDTO) {
        return modelMapper.map(tarefaDTO, Tarefa.class);
    }
}