package io.github.wendellvalentim.msclientes.controller.mappers;

import ch.qos.logback.core.model.ComponentModel;
import io.github.wendellvalentim.msclientes.controller.dto.ClienteRequestDTO;
import io.github.wendellvalentim.msclientes.model.Cliente;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteRequestDTO dto);

}
