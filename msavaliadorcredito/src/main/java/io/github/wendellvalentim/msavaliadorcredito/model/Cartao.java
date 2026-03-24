package io.github.wendellvalentim.msavaliadorcredito.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Cartao ( UUID id,
         String nome,
         String bandeira,
         BigDecimal limite){


}
