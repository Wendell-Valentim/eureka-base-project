package io.github.wendellvalentim.mscartoes.model;

import java.math.BigDecimal;
import java.util.UUID;

public record DadosSolicitacaoEmissaoCartao(UUID idCartao,
                                            String cpf,
                                            String endereco,
                                            BigDecimal limiteLiberado) {

}
