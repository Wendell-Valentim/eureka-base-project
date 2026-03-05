package io.github.wendellvalentim.msavaliadorcredito.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RetornoAvaliacaoCliente {
 private List<CartoesAprovados> cartoes;
}
