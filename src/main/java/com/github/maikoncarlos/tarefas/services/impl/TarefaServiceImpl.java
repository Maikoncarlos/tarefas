package com.github.maikoncarlos.tarefas.services.impl;

import com.github.maikoncarlos.tarefas.entities.TarefaEntity;
import com.github.maikoncarlos.tarefas.entities.dto.TarefaDTO;
import com.github.maikoncarlos.tarefas.entities.mapper.TarefaMapper;
import com.github.maikoncarlos.tarefas.exception.NotFoundTaskException;
import com.github.maikoncarlos.tarefas.repositories.TarefaRepository;
import com.github.maikoncarlos.tarefas.services.TarefaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private TarefaMapper tarefaMapper;

    public TarefaDTO createTask(@Valid TarefaDTO tarefaDTO) {
        log.info("SUCESSO - CRIANDO NOVA TAREFA:" + tarefaDTO);
        return tarefaMapper.toTarefaDTO(tarefaRepository.save(tarefaMapper.toTarefa(tarefaDTO)));
    }

    public List<TarefaDTO> getAllTasks() {
        List<TarefaEntity> tarefaEntityList = tarefaRepository.findAll();
        if (!tarefaEntityList.isEmpty()) {
            log.info("SUCESSO - BUSCANDO A LISTA DE TAREFAS:");
            return tarefaEntityList.stream()
                    .map(tarefaMapper::toTarefaDTO)
                    .collect(Collectors.toList());
        } else {
            log.error("ERROR - BUSCAR POR TODAS TAREFAS, NÃO EXISTE TAREFAS GRAVADAS");
            throw new NotFoundTaskException("Não tem tarefa");

        }
    }

    public TarefaDTO getTasksToId(Long id) {
        validarBuscaPorId(id);
        TarefaEntity tarefaEntity = tarefaRepository.findById(id).get();
        log.info("SUCESSO - BUSCAR TAREFA POR ID, TAREFA GRAVADA, ID: " + id);
        return tarefaMapper.toTarefaDTO(tarefaEntity);
    }

    public TarefaDTO updateTask(TarefaDTO tarefaDTO, Long id) {
        validarBuscaPorId(id);
        TarefaEntity task = tarefaMapper.toTarefa(tarefaDTO);
        task.setId(id);
        tarefaRepository.save(task);
        log.info("SUCESSO - ATUALIZANDO TAREFA:" + tarefaDTO);
        return tarefaDTO;
    }

    public void deleteTask(Long id) {
        validarBuscaPorId(id);
        TarefaEntity tarefaEntity = tarefaRepository.findById(id).get();
        log.info("SUCESSO - DELETADO TAREFA ID: " + tarefaEntity);
        tarefaRepository.delete(tarefaEntity);
    }

    private void validarBuscaPorId(Long id) {
        log.info("VERIFICANDO SE EXISTE TAREFA CADASTRADA COM ID : {}", id);
       tarefaRepository.findById(id)
                .orElseThrow(() -> new NotFoundTaskException("Não tem tarefa cadastrada com o ID: " + id));
       }

}