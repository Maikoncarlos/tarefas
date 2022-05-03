package com.github.maikoncarlos.tarefas.entities.mapper;

import com.github.maikoncarlos.tarefas.entities.TarefaEntity;
import com.github.maikoncarlos.tarefas.entities.dto.TarefaDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaMapper {
	TarefaDTO toTarefaDTO(TarefaEntity tarefaEntity);

	TarefaEntity toTarefa(TarefaDTO tarefaDTO);
}
