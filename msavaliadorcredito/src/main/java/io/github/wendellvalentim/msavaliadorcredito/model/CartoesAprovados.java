package io.github.wendellvalentim.msavaliadorcredito.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartoesAprovados {

    private String nome;
    private String bandeira;
    private BigDecimal limiteAprovado;
}
