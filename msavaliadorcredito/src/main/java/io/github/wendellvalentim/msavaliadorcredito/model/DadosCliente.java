package io.github.wendellvalentim.msavaliadorcredito.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;


public record DadosCliente ( UUID id,
         String nome,
         Integer idade,
         LocalDate dataNascimento) {

}
