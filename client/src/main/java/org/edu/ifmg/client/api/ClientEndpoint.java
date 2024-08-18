package org.edu.ifmg.client.api;
import lombok.AllArgsConstructor;

import org.edu.ifmg.client.exception.DefaultException;
import org.edu.ifmg.client.representation.RegisterClientDto;
import org.edu.ifmg.client.usecase.UseCaseDeleteClient;
import org.edu.ifmg.client.usecase.UseCaseFindClient;
import org.edu.ifmg.client.usecase.UseCaseRegisterClient;
import org.springframework.http.HttpStatusCode;
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
    private final UseCaseDeleteClient useCaseDeleteClient;

    @PostMapping
    public ResponseEntity<Object> save(@Validated @RequestBody RegisterClientDto registerClientDto){
        try {
            var client = registerClientDto.toModel();
            var savedClient = useCaseRegisterClient.register(client);
            var headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(savedClient.getCpf())
                .toUri();
            return ResponseEntity.created(headerLocation).build();        
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<Object> getByCpf(@RequestParam("cpf") String cpf){
        var client = useCaseFindClient.getByCpf(cpf);
        if(client.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/delete/cpf/{cpf}")
    public ResponseEntity<Object> deleteByCpf(@PathVariable String cpf){
        try {
            this.useCaseDeleteClient.deleteByCPF(cpf);
            return ResponseEntity.noContent().build();
        } catch (DefaultException e) {
            return ResponseEntity.status(HttpStatusCode.valueOf((int)(e.getCode().getId()))).build();
        }
    }

    @DeleteMapping("/delete/id/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable String id){
        try {
            this.useCaseDeleteClient.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (DefaultException e) {
            return ResponseEntity.status(HttpStatusCode.valueOf((int)(e.getCode().getId()))).build();
        }
    }

    @GetMapping
    public ResponseEntity<Object> getServerStatus(){
        return ResponseEntity.ok().build();
    }
}