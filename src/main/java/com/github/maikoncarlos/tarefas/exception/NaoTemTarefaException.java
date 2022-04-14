package com.github.maikoncarlos.tarefas.exception;

public class NaoTemTarefaException extends RuntimeException{

    private static final long serialVersionUID = 4928599035264976611L;

    public NaoTemTarefaException(String mensagem) {
        super(mensagem);
    }

    public NaoTemTarefaException(Throwable t) {
        super(t);
    }

}