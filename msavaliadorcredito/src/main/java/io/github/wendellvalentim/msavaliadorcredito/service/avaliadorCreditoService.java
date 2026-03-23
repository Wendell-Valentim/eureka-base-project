package io.github.wendellvalentim.msavaliadorcredito.service;

import io.github.wendellvalentim.msavaliadorcredito.infra.CartaoResourceClient;
import io.github.wendellvalentim.msavaliadorcredito.infra.ClienteResourceClient;
import io.github.wendellvalentim.msavaliadorcredito.infra.mqueue.SolicitacaoEmissaoCartaoPublisher;
import io.github.wendellvalentim.msavaliadorcredito.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class avaliadorCreditoService {
    private final ClienteResourceClient client;
    private final CartaoResourceClient  cartaoClient;
    private final SolicitacaoEmissaoCartaoPublisher emissaoCartaoPublisher;

    public SituacaoCliente obterSituacaoCliente(String cpf) {
        ResponseEntity<DadosCliente> dadosClientResponse = client.dadosCliente(cpf);
        ResponseEntity<List<CartaoCliente>> dadosCartaoResponse = cartaoClient.getCartoesByCliente(cpf);
        return SituacaoCliente.builder()
                .cliente(dadosClientResponse.getBody())
                .cartao(dadosCartaoResponse.getBody())
                .build();
    }

    public RetornoAvaliacaoCliente realizarAvaliacao(String cpf, Long renda) {
        ResponseEntity<DadosCliente> dadosClientResponse = client.dadosCliente(cpf);
        ResponseEntity<List<Cartao>> cartoesResponse = cartaoClient.getCartoesRendaAte(renda);

        List<Cartao> cartoes = cartoesResponse.getBody();
        var listaCartoesAprovados = cartoes.stream().map(cartao -> {
            DadosCliente dadosCliente = dadosClientResponse.getBody();

            BigDecimal limiteBasico = cartao.getLimite();
            BigDecimal idadeBD = BigDecimal.valueOf(dadosCliente.getIdade());

            BigDecimal fator = idadeBD.divide(BigDecimal.valueOf(10));
            BigDecimal limiteAprovado = fator.multiply(limiteBasico);

            CartoesAprovados aprovado = new CartoesAprovados();
            aprovado.setNome(cartao.getNome());
            aprovado.setBandeira(cartao.getBandeira());
            aprovado.setLimiteAprovado(limiteAprovado);

            return aprovado;
        }).collect(Collectors.toList());
        return new RetornoAvaliacaoCliente(listaCartoesAprovados);
    }

    public Protocolo solicitarEmissaoDeCartao (DadosSolicitacaoEmissaoCartao dados) {
        emissaoCartaoPublisher.solicitarCartao(dados);
        var protocolo = UUID.randomUUID();
        return new Protocolo(protocolo);
    }

}
