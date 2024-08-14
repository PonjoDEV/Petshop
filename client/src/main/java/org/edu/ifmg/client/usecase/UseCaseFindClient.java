package org.edu.ifmg.client.usecase;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.edu.ifmg.client.model.Client;
import org.edu.ifmg.client.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@AllArgsConstructor
@Service
public class UseCaseFindClient {

    private final ClientRepository repository;

    @Transactional
    public Optional<Client> getByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }

}
