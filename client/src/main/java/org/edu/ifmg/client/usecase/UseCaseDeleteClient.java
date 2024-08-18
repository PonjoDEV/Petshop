package org.edu.ifmg.client.usecase;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.edu.ifmg.client.exception.DefaultException;
import org.edu.ifmg.client.repository.ClientRepository;
import org.edu.ifmg.client.utility.ApiResponseCode;
import org.springframework.stereotype.Service;
import java.util.UUID;

@AllArgsConstructor
@Service
public class UseCaseDeleteClient {

    private final ClientRepository repository;

    @Transactional
    public boolean deleteByCPF(String cpf) {        
        if (repository.findByCpf(cpf).isEmpty())throw new DefaultException("CPF not found",ApiResponseCode.NOT_FOUND,null);
        repository.deleteByCpf(cpf);
        return true;
    }   
    
    @Transactional
    public boolean deleteById(String id) {
        if (repository.findById(UUID.fromString(id)).isEmpty())throw new DefaultException("ID not found",ApiResponseCode.NOT_FOUND,null);
        repository.deleteById(UUID.fromString(id));
        return true;
    }
}