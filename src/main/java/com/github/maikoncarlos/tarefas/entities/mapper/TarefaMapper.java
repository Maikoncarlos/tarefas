package com.github.maikoncarlos.tarefas.entities.mapper;

import com.github.maikoncarlos.tarefas.entities.Tarefa;
import com.github.maikoncarlos.tarefas.entities.dto.TarefaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaMapper {
    TarefaDTO toTarefaDTO(Tarefa tarefa);

    Tarefa toTarefa(TarefaDTO tarefaDTO);
}
