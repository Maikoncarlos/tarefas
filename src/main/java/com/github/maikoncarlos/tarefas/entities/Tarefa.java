package com.github.maikoncarlos.tarefas.entities;

import com.github.maikoncarlos.tarefas.enuns.TarefaStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @NotNull(message = "campo não pode ser nulo")
    private String descricao;

    @NotNull(message = "campo não pode ser nulo")
    private Integer tarefaStatus;

    public Tarefa(TarefaStatusEnum tarefaStatus) {
        setTarefaStatus(tarefaStatus);
    }

    public TarefaStatusEnum getTarefaStatus() {
        return TarefaStatusEnum.valueOf(tarefaStatus);
    }

    public void setTarefaStatus(TarefaStatusEnum tarefaStatus) {
        if (tarefaStatus != null){
            this.tarefaStatus = tarefaStatus.getCode();
        }
    }
}