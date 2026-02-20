package io.github.wendellvalentim.msclientes.controller.common;

import io.github.wendellvalentim.msclientes.controller.dto.ErroCampo;
import io.github.wendellvalentim.msclientes.controller.dto.ErroResposta;
import io.github.wendellvalentim.msclientes.exception.CpfJaCadastradoException;
import io.github.wendellvalentim.msclientes.exception.CpfNotFoundException;
import io.github.wendellvalentim.msclientes.exception.IdadeInsuficienteException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ErroResposta handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<FieldError> fieldErros = e.getFieldErrors();
        List<ErroCampo> listErros = fieldErros.stream()
                .map(fe -> new ErroCampo(fe.getField(), fe.getDefaultMessage()))
                .collect(Collectors.toList());
        return new ErroResposta(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Erro de validação!", listErros);

    }


    @ExceptionHandler(CpfJaCadastradoException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErroResposta handleCpfJaCadastradoException(CpfJaCadastradoException e) {
        return ErroResposta.conflito(e.getMessage());

    }

    @ExceptionHandler(CpfNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErroResposta handleCpfNotFoundException(CpfNotFoundException e) {
        return new ErroResposta(HttpStatus.NOT_FOUND.value(),e.getMessage(), List.of());

    }

    @ExceptionHandler(IdadeInsuficienteException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErroResposta handleIdadeInsuficienteException(IdadeInsuficienteException e) {
        return ErroResposta.respostaPadrao(e.getMessage());
    }


//    @ExceptionHandler(RuntimeException.class)
//    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//    public ErroResposta handleErrosNaoTratados (RuntimeException e) {
//
//        return new ErroResposta(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Erro inesperado, contate a administração!", List.of());
//    }

}
