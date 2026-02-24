package io.github.wendellvalentim.mscartoes.repository;

import io.github.wendellvalentim.mscartoes.model.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface CartaoRepository extends JpaRepository<Cartao, UUID> {
    List<Cartao> findByRendaLessThanEqual(BigDecimal renda);
}
