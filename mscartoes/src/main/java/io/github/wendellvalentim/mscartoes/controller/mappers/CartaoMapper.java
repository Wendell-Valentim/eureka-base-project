package io.github.wendellvalentim.mscartoes.controller.mappers;

import io.github.wendellvalentim.mscartoes.controller.dto.CartaoRequestDTO;
import io.github.wendellvalentim.mscartoes.model.Cartao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartaoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "codigo", ignore = true)
    Cartao toEntity(CartaoRequestDTO dto);
}
