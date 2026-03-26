package io.github.wendellvalentim.msavaliadorcredito.model.cliente;

import io.github.wendellvalentim.msavaliadorcredito.model.cartao.CartoesAprovados;

import java.util.List;

public record RetornoAvaliacaoCliente (List<CartoesAprovados> cartoes) {

}
