package io.github.wendellvalentim.mscartoes.service;

import io.github.wendellvalentim.mscartoes.model.ClienteCartao;
import io.github.wendellvalentim.mscartoes.repository.ClienteCartaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteCartaoService {

    private final ClienteCartaoRepository repository;

    public List<ClienteCartao> listCartoesByCpf(String cpf){
        return  repository.findByCpf(cpf);
    }
}
