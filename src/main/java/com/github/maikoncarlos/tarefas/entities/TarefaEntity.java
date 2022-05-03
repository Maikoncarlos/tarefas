package com.github.maikoncarlos.tarefas.entities;

import com.github.maikoncarlos.tarefas.enuns.TarefaStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;


@Table(name = "TB_TAREFAS")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class TarefaEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "descricao_tarefa", nullable = false)
    private String description;

    @Column(name = "titulo_tarefa", nullable = false)
    private Integer taskStatus;

    public TarefaEntity(TarefaStatusEnum taskStatus) {
        setTaskStatus(taskStatus);
    }

    public TarefaStatusEnum getTaskStatus() {
        return TarefaStatusEnum.valueOf(taskStatus);
    }

    public void setTaskStatus(TarefaStatusEnum taskStatus) {
        if (taskStatus != null) {
            this.taskStatus = taskStatus.getCode();
        }
    }
}