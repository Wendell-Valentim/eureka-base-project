package io.github.wendellvalentim.mscartoes.infra.mqueue.subscribre;

import io.github.wendellvalentim.mscartoes.infra.mqueue.records.DadosCartao;
import io.github.wendellvalentim.mscartoes.model.ClienteCartao;
import io.github.wendellvalentim.mscartoes.model.DadosSolicitacaoEmissaoCartao;
import io.github.wendellvalentim.mscartoes.repository.CartaoRepository;
import io.github.wendellvalentim.mscartoes.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EmissaoCartaoSubscriber {
    private final ClienteCartaoRepository clienteCartaoRepository;
    private final CartaoRepository cartaoRepository;

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receberSolicitacaoEmissao(@Payload DadosSolicitacaoEmissaoCartao dados) {
        var cartao =
    }
}
