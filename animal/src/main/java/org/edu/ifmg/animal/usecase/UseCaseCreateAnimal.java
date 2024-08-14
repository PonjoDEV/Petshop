package org.edu.ifmg.animal.usecase;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.edu.ifmg.animal.model.Animal;
import org.edu.ifmg.animal.repository.AnimalRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UseCaseCreateAnimal {

    private final AnimalRepository repositoryAnimal;

    @Transactional
    public Animal create(Animal animal) {
        return repositoryAnimal.save(animal);
    }
}
