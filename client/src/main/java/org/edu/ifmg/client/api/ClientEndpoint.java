package org.edu.ifmg.client.api;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.edu.ifmg.client.representation.RegisterClientDto;
import org.edu.ifmg.client.usecase.UseCaseFindClient;
import org.edu.ifmg.client.usecase.UseCaseRegisterClient;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("client")
@AllArgsConstructor
public class ClientEndpoint {

    private final UseCaseRegisterClient useCaseRegisterClient;
    private final UseCaseFindClient useCaseFindClient;

    @PostMapping
    public ResponseEntity<Object> save(@Validated @RequestBody RegisterClientDto registerClientDto){
        var client = registerClientDto.toModel();
        var savedClient = useCaseRegisterClient.register(client);
        var headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(savedClient.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<Object> getByCpf(@RequestParam("cpf") String cpf){
        var client = useCaseFindClient.getByCpf(cpf);
        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @GetMapping
    public ResponseEntity<Object> getServerStatus(){
        return ResponseEntity.ok().build();
    }
}
