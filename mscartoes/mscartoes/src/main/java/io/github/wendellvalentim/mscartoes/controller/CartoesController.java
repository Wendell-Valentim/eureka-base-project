package io.github.wendellvalentim.mscartoes.controller;

import io.github.wendellvalentim.mscartoes.controller.dto.CartaoRequestDTO;
import io.github.wendellvalentim.mscartoes.controller.dto.CartoesPorClienteResponse;
import io.github.wendellvalentim.mscartoes.controller.mappers.CartaoClienteMapper;
import io.github.wendellvalentim.mscartoes.controller.mappers.CartaoMapper;
import io.github.wendellvalentim.mscartoes.model.Cartao;
import io.github.wendellvalentim.mscartoes.model.ClienteCartao;
import io.github.wendellvalentim.mscartoes.service.CartaoService;
import io.github.wendellvalentim.mscartoes.service.ClienteCartaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartoes")
@RequiredArgsConstructor
public class CartoesController implements GenericController {

    private final CartaoService service;
    private final ClienteCartaoService clienteService;
    private final CartaoMapper mapper;
    private final CartaoClienteMapper clienteMapper;

    @GetMapping
    public String status() {
        return "OK";
    }

    @PostMapping
    public ResponseEntity<Void> cadastrar(@RequestBody CartaoRequestDTO request) {
        var cartao = mapper.toEntity(request);
        service.save(cartao);
        URI location = gerarHeaderLocation(cartao.getCodigo());
        return  ResponseEntity.created(location).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAte(@RequestParam("renda") Long renda) {
        List<Cartao> list = service.getCartoesRendaMenorIgual(renda);
        return  ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponse>> getCartoesByCliente(@RequestParam("cpf") String cpf){
        List<ClienteCartao> lista = clienteService.listCartoesByCpf(cpf);
        return ResponseEntity.ok(clienteMapper.toDTO(lista));
    }
}
