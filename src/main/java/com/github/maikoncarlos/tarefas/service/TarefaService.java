package com.github.maikoncarlos.tarefas.service;

import com.github.maikoncarlos.tarefas.controllers.dto.TarefaDTO;
import com.github.maikoncarlos.tarefas.entities.Tarefa;
import com.github.maikoncarlos.tarefas.repositories.TarefaRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public String createTask(TarefaDTO tarefaDTO) {
        return this.createTask(tarefaDTO, modelMapper);
    }

    private String createTask(TarefaDTO tarefaDTO, ModelMapper modelMapper) {
        try {
            Tarefa tarefa = tarefaRepository.save(tarefaDTOtoTarefa(tarefaDTO, modelMapper));
            return tarefa.getId() > 0 ? "Salvo com Sucesso!" : "";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public List<TarefaDTO> getAllTasks() {
        return tarefaRepository.findAll()
                .stream()
                .map(this::toTarefaDTO)
                .collect(Collectors.toList());
    }

    private Tarefa tarefaDTOtoTarefa(TarefaDTO tarefaDTO, ModelMapper modelMapper) {
        return modelMapper.map(tarefaDTO, Tarefa.class);
    }

    private TarefaDTO toTarefaDTO(Tarefa tarefa) {
        return modelMapper.map(tarefa, TarefaDTO.class);
    }

    public TarefaDTO getTasksToId(long id) {
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(NullPointerException::new);

        return toTarefaDTO(tarefa);
    }

    public ResponseEntity<TarefaDTO> updateTask(Tarefa tarefa, long id) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        if(!tarefaOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
          tarefa.setId(tarefaOptional.get().getId());
          tarefaRepository.save(tarefa);
          return new ResponseEntity<TarefaDTO>(toTarefaDTO(tarefa), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteTask(long id) {
        Optional<Tarefa> tarefaOptional = tarefaRepository.findById(id);
        if(!tarefaOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        tarefaRepository.delete(tarefaOptional.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}




