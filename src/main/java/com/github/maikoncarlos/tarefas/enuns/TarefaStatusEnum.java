package com.github.maikoncarlos.tarefas.enuns;

import lombok.Getter;

public enum TarefaStatusEnum {

    PENDENTE(1),
    EM_ANDAMENTO(2),
    CANCELADO(3),
    FINALIZADO(4);

    @Getter
    private int code;

    private TarefaStatusEnum(int code){
        this.code = code;
    }

    public static TarefaStatusEnum valueOf(int code) {
        for (TarefaStatusEnum value : TarefaStatusEnum.values()) {
            if (code == value.getCode()){
                return value;
            }
        }
        throw new IllegalArgumentException("staus do enum inválido");
    }
}