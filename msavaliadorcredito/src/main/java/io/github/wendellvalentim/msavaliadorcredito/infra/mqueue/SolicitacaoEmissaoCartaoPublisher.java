package io.github.wendellvalentim.msavaliadorcredito.infra.mqueue;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.wendellvalentim.msavaliadorcredito.model.DadosSolicitacaoEmissaoCartao;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SolicitacaoEmissaoCartaoPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue emissaoCartoesFila;

    public void solicitarCartao(DadosSolicitacaoEmissaoCartao dados) {

        rabbitTemplate.convertAndSend(emissaoCartoesFila.getName(), dados);
    }
}
