package org.edu.ifmg.client.representation;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.edu.ifmg.client.model.Client;

import java.util.UUID;

@Data
public class RegisterClientDto {

    @NotBlank(message = "O cpf deve ser informado") private String cpf;
    @NotBlank(message = "O nome deve ser informado") private String name;
    @Min(value = 1, message = "Digite um valor válido para a idade") @Max(value = 200, message = "Digite um valor válido para a idade") private Integer age;

    public Client toModel(){
        return Client.builder().name(this.name).age(this.age).cpf(this.cpf).build();
    }
}
