package io.github.wendellvalentim.mscartoes.infra.mqueue;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.wendellvalentim.mscartoes.exceptions.ErroEmissaoCartaoException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class RabbitMQConfig {

    @Bean
    public MessageConverter jsonMessageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory, MessageConverter messageConverter){
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();

        factory.setConnectionFactory(connectionFactory);

        factory.setMessageConverter(messageConverter);

        factory.setErrorHandler(t -> {
            var originalException = t.getCause();

            if (originalException instanceof ErroEmissaoCartaoException) {
                log.error("Erro de Negócio: ID inválido. Descartando mensagem: {}", originalException.getMessage());

                throw new AmqpRejectAndDontRequeueException(t.getMessage(), t);
            } else {
                log.error("Erro de Infra/Inesperado: Tentando processar novamente... {}", t.getMessage());

            }
        });
        return factory;
}}
