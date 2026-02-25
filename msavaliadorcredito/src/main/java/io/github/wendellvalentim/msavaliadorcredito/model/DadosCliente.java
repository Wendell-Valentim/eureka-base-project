package io.github.wendellvalentim.msavaliadorcredito.model;

import lombok.Data;

import java.util.UUID;

@Data
public class DadosCliente {
    private UUID id;
    private String nome;
}
