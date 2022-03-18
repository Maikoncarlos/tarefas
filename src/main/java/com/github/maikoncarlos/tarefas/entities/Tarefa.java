package com.github.maikoncarlos.tarefas.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@Table(name = "TB_TAREFAS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tarefa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String descricao;

    @NotNull()
    private String status;


}
