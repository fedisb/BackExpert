package com.avis.expertmanager.service;

import com.avis.expertmanager.exception.UserNotFoundException;
import com.avis.expertmanager.model.Client;
import com.avis.expertmanager.model.Expert;
import com.avis.expertmanager.repository.ClientRepo;
import com.avis.expertmanager.repository.ExpertRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {
    private final ClientRepo clientRepo;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public ClientService(ClientRepo clientRepo, BCryptPasswordEncoder passwordEncoder) {

        this.clientRepo = clientRepo;
        this.passwordEncoder = passwordEncoder;
    }



    public Client addClient(Client client) {
        client.setOfferDescription(UUID.randomUUID().toString());
        return clientRepo.save(client);
    }

    public List<Client> findAllClient() {
        return clientRepo.findAll();
    }

    public Client updateClient(Client client){
        return clientRepo.save(client);
    }

    public Client findClientByID(Long id){
        return clientRepo.findClientById(id)
                .orElseThrow(() -> new UserNotFoundException("User By Id "+id+" Was Not Found"));
    }
    @Transactional
    public void deleteClient(Long id){
        clientRepo.delete(new Client(id));
    }
}
