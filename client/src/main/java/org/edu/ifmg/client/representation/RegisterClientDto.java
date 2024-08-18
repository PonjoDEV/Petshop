package org.edu.ifmg.client.representation;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.edu.ifmg.client.anotation.IsValidCPF;
import org.edu.ifmg.client.model.Client;

@Data
public class RegisterClientDto {

    @IsValidCPF(message = "O número do CPF não é válido") private String cpf;
    @NotBlank(message = "O nome deve ser informado") private String name;
    @Min(value = 1, message = "Digite um valor válido para a idade") @Max(value = 200, message = "Digite um valor válido para a idade") private Integer age;

    public Client toModel(){
        return Client.builder().name(this.name).age(this.age).cpf(this.cpf.replaceAll("\\D","")).build();
    }
}
