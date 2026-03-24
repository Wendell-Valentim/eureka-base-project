package io.github.wendellvalentim.msavaliadorcredito.controller;

import io.github.wendellvalentim.msavaliadorcredito.model.*;
import io.github.wendellvalentim.msavaliadorcredito.service.avaliadorCreditoService;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacoes-credito")
@RequiredArgsConstructor
public class AvaliadorCreditoController {

    private final avaliadorCreditoService service;

    @GetMapping
    public String status(){
        return "OK";
    }

    @GetMapping(value ="situacao-cliente", params = "cpf")
    public ResponseEntity<SituacaoCliente> consultaSituacaoCliente (@RequestParam("cpf") String cpf) {
        SituacaoCliente situacaoCliente = service.obterSituacaoCliente(cpf);
        return ResponseEntity.ok(situacaoCliente);
    }

    @PostMapping
    public ResponseEntity<RetornoAvaliacaoCliente> realizarAvaliacao(@RequestBody DadosAvaliacao dados) {
        val retornoAvaliacaoCliente = service.realizarAvaliacao(dados.cpf(), dados.renda());
        return ResponseEntity.ok(retornoAvaliacaoCliente);
    }

    @PostMapping("solicitacoes-cartao")
    public ResponseEntity<Protocolo> emissaoCartao(@RequestBody DadosSolicitacaoEmissaoCartao dados) {
        Protocolo protocolo = service.solicitarEmissaoDeCartao(dados);
        return ResponseEntity.ok(protocolo);
    }

}
