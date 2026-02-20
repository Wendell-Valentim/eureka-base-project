package io.github.wendellvalentim.msclientes.controller;

import io.github.wendellvalentim.msclientes.controller.dto.ClienteRequestDTO;
import io.github.wendellvalentim.msclientes.controller.mappers.ClienteMapper;
import io.github.wendellvalentim.msclientes.model.Cliente;
import io.github.wendellvalentim.msclientes.service.ClienteService;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClienteController implements GenericController {

    private final ClienteService service;

    private final ClienteMapper mapper;



    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid ClienteRequestDTO request) {
        Cliente cliente = mapper.toEntity(request);
        service.salvar(cliente);
        URI location = gerarHeaderLocation(cliente.getCpf());
        return ResponseEntity.created(location).build();
    }

    @GetMapping
    public ResponseEntity<Cliente> dadosCliente(@RequestParam("cpf") String cpf) {
        var cliente = service.buscarPorCpf(cpf);
        return ResponseEntity.ok(cliente);
    }
}
