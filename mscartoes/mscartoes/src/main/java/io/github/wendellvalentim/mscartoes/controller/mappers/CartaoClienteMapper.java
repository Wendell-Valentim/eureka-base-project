package io.github.wendellvalentim.mscartoes.controller.mappers;

import io.github.wendellvalentim.mscartoes.controller.dto.CartoesPorClienteResponse;
import io.github.wendellvalentim.mscartoes.model.ClienteCartao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CartaoClienteMapper {
    List<CartoesPorClienteResponse> toDTO(List<ClienteCartao> cliente);
}
