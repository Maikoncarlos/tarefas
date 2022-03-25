package com.github.maikoncarlos.tarefas.repositories;

import com.github.maikoncarlos.tarefas.entities.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
