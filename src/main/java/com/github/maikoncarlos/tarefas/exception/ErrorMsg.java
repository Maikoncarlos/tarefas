package com.github.maikoncarlos.tarefas.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMsg {

    private Date dataOcorrido;
    private String mensagem;
}