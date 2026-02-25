package io.github.wendellvalentim.msavaliadorcredito.service;

import io.github.wendellvalentim.msavaliadorcredito.infra.CartaoResourceClient;
import io.github.wendellvalentim.msavaliadorcredito.infra.ClienteResourceClient;
import io.github.wendellvalentim.msavaliadorcredito.model.CartaoCliente;
import io.github.wendellvalentim.msavaliadorcredito.model.DadosCliente;
import io.github.wendellvalentim.msavaliadorcredito.model.SituacaoCliente;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class avaliadorCreditoService {
    private final ClienteResourceClient client;
    private final CartaoResourceClient  cartaoClient;

    public SituacaoCliente obterSituacaoCliente(String cpf) {
        ResponseEntity<DadosCliente> dadosClientResponse = client.dadosCliente(cpf);
        ResponseEntity<List<CartaoCliente>> dadosCartaoResponse = cartaoClient.getCartoesByCliente(cpf);
        return SituacaoCliente.builder()
                .cliente(dadosClientResponse.getBody())
                .cartao(dadosCartaoResponse.getBody())
                .build();
    }

}
