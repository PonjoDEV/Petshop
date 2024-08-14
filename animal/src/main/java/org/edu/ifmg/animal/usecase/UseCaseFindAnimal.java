package org.edu.ifmg.animal.usecase;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.edu.ifmg.animal.model.Animal;
import org.edu.ifmg.animal.repository.AnimalRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UseCaseFindAnimal {
    private final AnimalRepository repository;

    @Transactional
    public Optional<Animal> getAnimalById(String id) {
        return repository.findById(UUID.fromString(id));
    }
}
