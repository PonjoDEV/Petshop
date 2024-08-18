package org.edu.ifmg.client.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Getter
@Setter
@Table(name = "client", indexes = {@Index(name = "client__id_idx", columnList = "id")})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Client extends BaseModel {

    private String name;
    @Column(unique=true)
    private String cpf;
    private Integer age;

}
