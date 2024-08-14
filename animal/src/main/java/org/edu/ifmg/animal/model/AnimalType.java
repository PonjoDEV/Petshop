package org.edu.ifmg.animal.model;

public enum AnimalType {
    DOG("Cachorro"),
    CAT("Gato");

    private String name;

    AnimalType(String name) {
        this.name = name;
    }
}
