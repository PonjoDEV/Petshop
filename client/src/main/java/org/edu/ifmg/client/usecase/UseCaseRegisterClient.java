package org.edu.ifmg.client.usecase;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.edu.ifmg.client.model.Client;
import org.edu.ifmg.client.repository.ClientRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UseCaseRegisterClient {

    private final ClientRepository repository;

    @Transactional
    public Client register(Client client) throws Exception{
        if (repository.findByCpf(client.getCpf()).isPresent()) throw new Exception("CPF already exists");        
        return repository.save(client);
    }
}
