package io.github.wendellvalentim.mscartoes.infra.mqueue.subscriber;

import io.github.wendellvalentim.mscartoes.exceptions.ErroEmissaoCartaoException;
import io.github.wendellvalentim.mscartoes.model.Cartao;
import io.github.wendellvalentim.mscartoes.model.ClienteCartao;
import io.github.wendellvalentim.mscartoes.model.DadosSolicitacaoEmissaoCartao;
import io.github.wendellvalentim.mscartoes.repository.CartaoRepository;
import io.github.wendellvalentim.mscartoes.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class EmissaoCartaoSubscriber {
    private final ClienteCartaoRepository clienteCartaoRepository;
    private final CartaoRepository cartaoRepository;

    @RabbitListener(queues = "${mq.queues.emissao-cartoes}")
    public void receberSolicitacaoEmissao(@Payload DadosSolicitacaoEmissaoCartao dados) {
        log.info("Iniciando emissão de cartão para o CPF: {}", dados.cpf());

        Cartao cartao = cartaoRepository.
                findById(dados.idCartao()).orElseThrow(() -> new ErroEmissaoCartaoException("Erro: Cartão ID " + dados.idCartao() + " não encontrado no banco!"));

        var clienteCartao = new ClienteCartao();
        clienteCartao.setCartao(cartao);
        clienteCartao.setCpf(dados.cpf());
        clienteCartao.setLimite(dados.limiteLiberado());

        clienteCartaoRepository.save(clienteCartao);

        log.info("Cartão emitido com sucesso para o CPF: {}", dados.cpf());
    }
}
