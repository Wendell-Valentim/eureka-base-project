package io.github.wendellvalentim.msavaliadorcredito.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public record SituacaoCliente (DadosCliente cliente,
         List<CartaoCliente> cartao){

}
