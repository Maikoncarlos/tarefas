package com.github.maikoncarlos.tarefas.enuns;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

public enum TarefaStatusEnum {

    PENDENTE("P"),
    EM_ANDAMENTO("E"),
    CANCELADO("C"),
    FINALIZADO("F");


    private String status;

    TarefaStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    @Converter(autoApply = true)
    public static class Mapeador implements AttributeConverter<TarefaStatusEnum, String> {

        @Override
        public String convertToDatabaseColumn(TarefaStatusEnum status) {
            return status.getStatus();
        }

        @Override
        public TarefaStatusEnum convertToEntityAttribute(String dbData) {
            return null;
        }

    }
}