package io.github.wendellvalentim.msavaliadorcredito.controller.common;

import feign.FeignException;
import feign.RetryableException;
import io.github.wendellvalentim.msavaliadorcredito.controller.dto.ErroResposta;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<String> handleFeignException(FeignException e) {
        int status = e.status();

        String corpoErro = e.contentUTF8();

        if (corpoErro == null || corpoErro.isEmpty()) {
            corpoErro = "{\"mensagem\": \"Erro inesperado no serviço externo\"}";
        }

        return ResponseEntity
                .status(status)
                .contentType(MediaType.APPLICATION_JSON)
                .body(corpoErro);
    }

    @ExceptionHandler(RetryableException.class)
    public ResponseEntity<ErroResposta> handleRetryableException(RetryableException e) {
        String url = e.request().url();
        String nomeServico = "Externo";

        // Identifica qual serviço falhou com base no path do FeignClient
        if (url.contains("/clientes")) {
            nomeServico = "Clientes";
        } else if (url.contains("/cartoes")) {
            nomeServico = "Cartões";
        }

        return ResponseEntity
                .status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(new ErroResposta("Falha de comunicação: o microserviço de " + nomeServico + " está fora do ar."));
    }
}

//String nomeServico = switch (url) {
//    case String u && u.contains("/clientes") -> "Clientes";
//    case String u && u.contains("/cartoes")  -> "Cartões";
//    default -> "Externo";
//};
