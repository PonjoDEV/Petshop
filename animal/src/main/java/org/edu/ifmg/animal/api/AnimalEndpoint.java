package org.edu.ifmg.animal.api;

import lombok.AllArgsConstructor;
import org.edu.ifmg.animal.representation.CreateAnimalDto;
import org.edu.ifmg.animal.usecase.UseCaseCreateAnimal;
import org.edu.ifmg.animal.usecase.UseCaseFindAnimal;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("animal")
@AllArgsConstructor
public class AnimalEndpoint {
    private final UseCaseCreateAnimal useCaseCreateAnimal;
    private final UseCaseFindAnimal useCaseFindAnimal;

    @PostMapping
    public ResponseEntity<Object> save(@Validated @RequestBody CreateAnimalDto dto) {
        var animal = dto.toModel();
        var savedAnimal = useCaseCreateAnimal.create(animal);
        var headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("id={id}")
                .buildAndExpand(savedAnimal.getId())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "id")
    public ResponseEntity<Object> getById(@RequestParam("id") String id){
        var animal = useCaseFindAnimal.getAnimalById(id);
        if(animal.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(animal);
    }

    @GetMapping
    public ResponseEntity<Object> getServerStatus(){
        return ResponseEntity.ok().build();
    }
}