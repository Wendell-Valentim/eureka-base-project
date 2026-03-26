package io.github.wendellvalentim.msavaliadorcredito.model.cliente;

import io.github.wendellvalentim.msavaliadorcredito.model.cartao.CartaoCliente;

import java.util.List;

public record SituacaoCliente (DadosCliente cliente,
                               List<CartaoCliente> cartao){

}
