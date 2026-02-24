package io.github.wendellvalentim.mscartoes.repository;

import io.github.wendellvalentim.mscartoes.model.ClienteCartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClienteCartaoRepository extends JpaRepository<ClienteCartao, UUID> {

    List<ClienteCartao> findByCpf(String cpf);
}
