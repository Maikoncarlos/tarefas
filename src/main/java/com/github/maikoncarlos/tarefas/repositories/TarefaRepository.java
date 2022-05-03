package com.github.maikoncarlos.tarefas.repositories;

import com.github.maikoncarlos.tarefas.entities.TarefaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TarefaRepository extends JpaRepository<TarefaEntity, UUID> {

}
