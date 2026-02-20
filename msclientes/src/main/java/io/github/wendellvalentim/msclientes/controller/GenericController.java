package io.github.wendellvalentim.msclientes.controller;

import io.github.wendellvalentim.msclientes.model.Cliente;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
public interface GenericController {

    default URI gerarHeaderLocation(String cpf){
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{cpf}")
                .buildAndExpand(cpf)
                .toUri();
    }
}
