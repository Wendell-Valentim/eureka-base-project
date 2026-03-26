package io.github.wendellvalentim.msavaliadorcredito.model.cartao;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Cartao ( UUID id,
         String nome,
         String bandeira,
         BigDecimal limite){


}
