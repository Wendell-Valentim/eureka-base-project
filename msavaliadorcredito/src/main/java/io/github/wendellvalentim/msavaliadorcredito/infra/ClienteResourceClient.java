package io.github.wendellvalentim.msavaliadorcredito.infra;

import io.github.wendellvalentim.msavaliadorcredito.model.DadosCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "msclientes", path = "/clientes")
public interface ClienteResourceClient {

    @GetMapping("/{cpf}")
     ResponseEntity<DadosCliente> dadosCliente(@PathVariable("cpf") String cpf);
}
