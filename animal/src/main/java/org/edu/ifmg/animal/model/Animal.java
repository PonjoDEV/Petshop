package org.edu.ifmg.animal.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "animal", indexes = {@Index(name = "animal__id_idx", columnList = "id")})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Animal extends BaseModel{

    private String name;
    private Integer age;
    private Float height;
    private Float weight;

    @Enumerated(EnumType.STRING)
    @Column(name = "animal_type")
    private AnimalType type;
}
