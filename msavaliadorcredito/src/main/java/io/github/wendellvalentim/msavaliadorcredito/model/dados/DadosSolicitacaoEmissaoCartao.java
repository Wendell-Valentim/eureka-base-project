package io.github.wendellvalentim.msavaliadorcredito.model.dados;

import java.math.BigDecimal;
import java.util.UUID;


public record DadosSolicitacaoEmissaoCartao(UUID idCartao,
        String cpf,
        String endereco,
        BigDecimal limiteLiberado) {

}
