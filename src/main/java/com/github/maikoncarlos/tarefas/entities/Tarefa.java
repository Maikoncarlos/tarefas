package com.github.maikoncarlos.tarefas.entities;

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

    @NotNull
    private String tarefaStatus;


//    public String getTarefaStatus() {
//        return TarefaStatusEnum.toEnum(this.tarefaStatus).getDescription();
//    }
//
//    public void setTarefaStatus(String tarefaStatus) {
//        this.tarefaStatus = tarefaStatus;
//    }
}