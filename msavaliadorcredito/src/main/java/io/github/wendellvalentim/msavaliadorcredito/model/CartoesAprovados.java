package io.github.wendellvalentim.msavaliadorcredito.model;

import lombok.Data;

import java.math.BigDecimal;


public record CartoesAprovados (String nome,
         String bandeira,
         BigDecimal limiteAprovado ){


}
