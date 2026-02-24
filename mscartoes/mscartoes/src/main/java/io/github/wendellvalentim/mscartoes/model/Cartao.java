package io.github.wendellvalentim.mscartoes.model;

import io.github.wendellvalentim.mscartoes.model.enums.BandeiraCartao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "codigo", unique = true, nullable = false)
    private UUID codigo;

    private String nome;

    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeira;

    private BigDecimal renda;

    private BigDecimal limite;

    public Cartao(String nome,UUID codigo, BandeiraCartao bandeira, BigDecimal renda, BigDecimal limite) {
        this.nome = nome;
        this.codigo = codigo;
        this.bandeira = bandeira;
        this.renda = renda;
        this.limite = limite;
    }
}
