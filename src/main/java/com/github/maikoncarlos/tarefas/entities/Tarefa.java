package com.github.maikoncarlos.tarefas.entities;

import com.github.maikoncarlos.tarefas.enuns.TarefaStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;


@Table(name = "TB_TAREFAS")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Tarefa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String description;

    private Integer taskStatus;

    public Tarefa(TarefaStatusEnum taskStatus) {
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