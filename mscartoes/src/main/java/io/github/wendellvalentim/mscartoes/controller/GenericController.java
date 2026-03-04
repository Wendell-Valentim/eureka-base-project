package io.github.wendellvalentim.mscartoes.controller;

import io.github.wendellvalentim.mscartoes.model.Cartao;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.UUID;

public interface GenericController {

    default URI gerarHeaderLocation(UUID codigo){
        return ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{codigo}")
                .buildAndExpand(codigo)
                .toUri();
    }
}
