package io.github.wendellvalentim.msclientes.service;

import io.github.wendellvalentim.msclientes.exception.CpfNotFoundException;
import io.github.wendellvalentim.msclientes.model.Cliente;
import io.github.wendellvalentim.msclientes.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente salvar(Cliente cliente){
        return clienteRepository.save(cliente);
    }

    public Cliente buscarPorCpf(String cpf){
        return clienteRepository.findByCpf(cpf).
                orElseThrow(() -> new CpfNotFoundException("Cliente não encontrado pelo cpf:" + cpf));
    }
}
