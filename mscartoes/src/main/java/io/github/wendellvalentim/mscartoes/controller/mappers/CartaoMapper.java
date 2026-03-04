package io.github.wendellvalentim.mscartoes.controller.mappers;

import io.github.wendellvalentim.mscartoes.controller.dto.CartaoRequestDTO;
import io.github.wendellvalentim.mscartoes.model.Cartao;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartaoMapper {
    Cartao toEntity(CartaoRequestDTO dto);
}
