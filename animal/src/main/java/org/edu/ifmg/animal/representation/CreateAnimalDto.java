package org.edu.ifmg.animal.representation;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.edu.ifmg.animal.model.Animal;
import org.edu.ifmg.animal.model.AnimalType;

@Data
public class CreateAnimalDto {

    @NotBlank(message = "O nome deve ser informado") private String name;
    @Min(value = 1, message = "Digite um valor válido para a idade") @Max(value = 200, message = "Digite um valor válido para a idade")  Integer age;
    @Positive(message = "O peso deve ser válido") private Float height;
    @Positive(message = "O peso deve ser válido") private Float weight;
    @NotNull(message="Digite o tipo do animal") private AnimalType type;

    public Animal toModel(){
        return Animal.builder().
                name(name).
                age(age).
                height(height).
                weight(weight).
                type(type).
                build();
    }
}
