package com.github.maikoncarlos.tarefas.entities;

import com.github.maikoncarlos.tarefas.enuns.TarefaStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


@Table(name = "TB_TAREFAS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tarefa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "campo não pode ser nulo")
    private String descricao;

    @NotNull
    @Convert(converter = TarefaStatusEnum.Mapeador.class)
    private TarefaStatusEnum tarefaStatus;


}