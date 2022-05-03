package com.github.maikoncarlos.tarefas.services;

import com.github.maikoncarlos.tarefas.entities.dto.TarefaDTO;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface TarefaService {

    TarefaDTO createTask(@Valid TarefaDTO tarefaDTO);

    List<TarefaDTO> getAllTasks();

    TarefaDTO getTasksToId(UUID id);

    TarefaDTO updateTask(@Valid TarefaDTO tarefaDTO, UUID id);

    void deleteTask(UUID id);
}
