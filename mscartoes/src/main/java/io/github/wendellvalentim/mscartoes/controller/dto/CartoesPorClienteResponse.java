package io.github.wendellvalentim.mscartoes.controller.dto;

import java.math.BigDecimal;

public record CartoesPorClienteResponse(
        String nome,
        String bandeira,
        BigDecimal limiteLiberado
        ) {
}
