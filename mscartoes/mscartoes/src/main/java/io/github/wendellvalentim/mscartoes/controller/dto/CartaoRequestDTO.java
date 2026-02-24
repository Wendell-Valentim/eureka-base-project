package io.github.wendellvalentim.mscartoes.controller.dto;

import io.github.wendellvalentim.mscartoes.model.enums.BandeiraCartao;

import java.math.BigDecimal;

public record CartaoRequestDTO(
        String nome,
        BandeiraCartao bandeira,
        BigDecimal renda,
        BigDecimal limite
){
}
