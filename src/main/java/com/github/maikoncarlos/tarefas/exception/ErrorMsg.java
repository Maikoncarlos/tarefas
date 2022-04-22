package com.github.maikoncarlos.tarefas.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMsg implements Serializable {

    private Date dataOcorrido;
    private String mensagem;
    private String detalhes;
}