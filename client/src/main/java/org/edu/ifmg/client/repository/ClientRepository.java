package org.edu.ifmg.client.repository;

import org.edu.ifmg.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {
    Optional<Client> findByCpf(String cpf);
    Optional<Client> deleteByCpf(String cpf);
    //Optional<Client> deleteById(String id);
}