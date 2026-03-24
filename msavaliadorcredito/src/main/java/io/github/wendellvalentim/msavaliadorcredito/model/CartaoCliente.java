package io.github.wendellvalentim.msavaliadorcredito.model;

import lombok.Data;

import java.math.BigDecimal;


public record CartaoCliente ( String nome,
         String bandeira,
         BigDecimal limiteLiberado){

}
