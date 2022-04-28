package com.github.maikoncarlos.tarefas.services;

import com.github.maikoncarlos.tarefas.entities.Tarefa;
import com.github.maikoncarlos.tarefas.entities.dto.TarefaDTO;
import com.github.maikoncarlos.tarefas.exception.NotFoundTaskException;
import com.github.maikoncarlos.tarefas.repositories.TarefaRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ModelMapper modelMapper;


    public TarefaDTO createTask(TarefaDTO tarefaDTO) {
        log.info("SUCESSO - CRIANDO NOVA TAREFA:" + tarefaDTO);
        return toTarefaDTO(tarefaRepository.save(toTarefa(tarefaDTO)));
    }

    public List<TarefaDTO> getAllTasks() {
        List<Tarefa> tarefaList = tarefaRepository.findAll();
        if (!tarefaList.isEmpty()) {
            log.info("SUCESSO - BUSCANDO A LISTA DE TAREFAS:");
            return tarefaList.stream()
                    .map(this::toTarefaDTO)
                    .collect(Collectors.toList());
        } else {
            log.error("ERROR - BUSCAR POR TODAS TAREFAS, NÃO EXISTE TAREFAS GRAVADAS");
            throw new NotFoundTaskException("Não tem tarefa");

        }
    }

    public TarefaDTO getTasksToId(long id) {
        validarBuscaPorId(id);
        Tarefa tarefa = tarefaRepository.findById(id).get();
        log.info("SUCESSO - BUSCAR TAREFA POR ID, TAREFA GRAVADA, ID: " + id);
        return toTarefaDTO(tarefa);
    }

    public TarefaDTO updateTask(TarefaDTO tarefaDTO, long id) {
        validarBuscaPorId(id);
        Tarefa task = toTarefa(tarefaDTO);
        task.setId(id);
        tarefaRepository.save(task);
        log.info("SUCESSO - ATUALIZANDO TAREFA:" + tarefaDTO);
        return tarefaDTO;
    }

    public void deleteTask(long id) {
        validarBuscaPorId(id);
        Tarefa tarefa = tarefaRepository.findById(id).get();
        log.info("SUCESSO - DELETADO TAREFA ID: {}", id);
        tarefaRepository.delete(tarefa);
    }

    private void validarBuscaPorId(long id) {
        log.error("ERROR - BUSCAR TAREFA POR ID, NÃO TEM TAREFA GRAVADA COM ID:  " + id);
        Tarefa tarefa = tarefaRepository.findById(id)
                .orElseThrow(() -> new NotFoundTaskException("Não tem tarefa com este ID: " + id));
    }

    private TarefaDTO toTarefaDTO(Tarefa tarefa) {
        return modelMapper.map(tarefa, TarefaDTO.class);
    }

    private Tarefa toTarefa(TarefaDTO tarefaDTO) {
        return modelMapper.map(tarefaDTO, Tarefa.class);
    }
}