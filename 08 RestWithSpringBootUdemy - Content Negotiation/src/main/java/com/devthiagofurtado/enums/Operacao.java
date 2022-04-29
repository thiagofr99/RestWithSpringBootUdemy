package com.devthiagofurtado.enums;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;


public enum Operacao {

    MULTIPLICACAO(1,"MULTIPLICAÇÃO"),
    DIVISAO(2,"DIVISÃO"),
    SOMA(3,"SOMA"),
    SUBTRACAO(4,"SUBTRAÇÃO"),
    MEDIA(5,"MÉDIA"),
    RAIZ_QUADRADA(6,"RAIZ QUADRADA");

    private Operacao(Integer codigo, String descricao){
        this.codigo=codigo;
        this.descricao = descricao;
    }

    private Integer codigo;
    private String descricao;

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

}
