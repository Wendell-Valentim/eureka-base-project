package io.github.wendellvalentim.msavaliadorcredito.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class Cartao {
    private UUID id;
    private String nome;
    private String bandeira;
    private BigDecimal limite;

}
