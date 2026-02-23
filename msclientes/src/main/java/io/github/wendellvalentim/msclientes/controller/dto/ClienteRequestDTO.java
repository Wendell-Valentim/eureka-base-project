package io.github.wendellvalentim.msclientes.controller.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;


public record ClienteRequestDTO(
        @CPF(message = "Preicsa conter 11 digitos!")
        @NotBlank(message = "Campo obrigatorio!")
        String cpf,

        @NotBlank(message="Campo obrigatorio")
        String nome,

        @Past
        @NotNull
        @JsonFormat(pattern = "dd/MM/yyyy")
         LocalDate dataNascimento
){

        }
