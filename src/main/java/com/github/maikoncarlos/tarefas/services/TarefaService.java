package com.github.maikoncarlos.tarefas.services;

import com.github.maikoncarlos.tarefas.entities.dto.TarefaDTO;

import javax.validation.Valid;
import java.util.List;

public interface TarefaService {

    TarefaDTO createTask(@Valid TarefaDTO tarefaDTO);

    List<TarefaDTO> getAllTasks();

    TarefaDTO getTasksToId(long id);

    TarefaDTO updateTask(@Valid TarefaDTO tarefaDTO, long id);

    void deleteTask(long id);
}
