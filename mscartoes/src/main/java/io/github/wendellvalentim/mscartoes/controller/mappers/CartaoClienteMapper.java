package io.github.wendellvalentim.mscartoes.controller.mappers;

import io.github.wendellvalentim.mscartoes.controller.dto.CartoesPorClienteResponse;
import io.github.wendellvalentim.mscartoes.model.ClienteCartao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface CartaoClienteMapper {
    @Mapping(target = "nome", source = "cartao.nome")
    @Mapping(target = "bandeira", source = "cartao.bandeira")
    @Mapping(target = "limiteLiberado", source = "limite")
    CartoesPorClienteResponse toDTO(ClienteCartao cliente);
}
