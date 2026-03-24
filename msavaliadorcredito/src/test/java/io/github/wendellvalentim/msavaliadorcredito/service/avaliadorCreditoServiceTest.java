package io.github.wendellvalentim.msavaliadorcredito.service;


import feign.FeignException;
import io.github.wendellvalentim.msavaliadorcredito.infra.CartaoResourceClient;
import io.github.wendellvalentim.msavaliadorcredito.infra.ClienteResourceClient;
import io.github.wendellvalentim.msavaliadorcredito.model.DadosCliente;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static  org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class avaliadorCreditoServiceTest {
        String cpf = "02413058190";

        @InjectMocks
        avaliadorCreditoService service;

        @Mock
        ClienteResourceClient client;

        @Mock
        CartaoResourceClient cartaoClient;

    @Test
    void deveObterASituacaoDoCliente() {

        DadosCliente dadosMock = new DadosCliente(
                UUID.fromString("7a367980-475a-4adb-90a0-d89aee05e9de"),
                "Wendell",
                24,
                LocalDate.of(2001, 10, 5)
        );

        when(client.dadosCliente(any())).thenReturn(ResponseEntity.ok(dadosMock));

        when(cartaoClient.getCartoesByCliente(any())).thenReturn(ResponseEntity.ok(java.util.List.of()));

        var situacao = service.obterSituacaoCliente(cpf);

        assertNotNull(situacao);
    }

    @Test
    void deveDarErroAoTentarObterASituacaoDoCliente() {
      
        when(client.dadosCliente(cpf))
                .thenThrow(FeignException.NotFound.class);


        assertThrows(FeignException.class, () -> {
            service.obterSituacaoCliente(cpf);
        });


        verifyNoInteractions(cartaoClient);
    }


}
