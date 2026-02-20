package io.github.wendellvalentim.msclientes.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String cpf;

    @Column
    private String nome;

    @Column
    private LocalDate dataNascimento;

    @CreatedDate
    private LocalDateTime dataCadastro;

    @LastModifiedDate
    private LocalDateTime dataAtualizacao;
}
