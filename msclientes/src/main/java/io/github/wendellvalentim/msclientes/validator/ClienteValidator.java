package io.github.wendellvalentim.msclientes.validator;


import io.github.wendellvalentim.msclientes.exception.CpfJaCadastradoException;
import io.github.wendellvalentim.msclientes.exception.IdadeInsuficienteException;
import io.github.wendellvalentim.msclientes.model.Cliente;
import io.github.wendellvalentim.msclientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ClienteValidator {

    private final ClienteRepository repository;

    public void validar(Cliente cliente) {
        if(calcularIdade(cliente.getDataNascimento()) < 18) {
            throw new IdadeInsuficienteException("Menor de idade não permitido.");
        }
        if(cpfExistente(cliente)) {
            throw new CpfJaCadastradoException("CPF ja cadastrado!");
        }
    }

    private Integer calcularIdade(LocalDate dataNascimento) {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    private boolean cpfExistente(Cliente cliente) {

       return repository.findByCpf(cliente.getCpf()).isPresent();
    }
}
