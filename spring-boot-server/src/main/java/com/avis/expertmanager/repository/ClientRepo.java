package com.avis.expertmanager.repository;

import com.avis.expertmanager.model.Client;
import com.avis.expertmanager.model.Expert;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepo extends JpaRepository<Client, Long> {
    void deleteClientById(Long id);

    Optional<Client> findClientById(Long id);
    Optional<Client> findByEmail(String email);
}

