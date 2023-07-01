package com.example.dbmicroservice.service;

import com.example.dbmicroservice.model.Client;
import com.example.dbmicroservice.repository.ClientRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImp implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Client> getListOfClients() {
        return clientRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void saveClient(Client client) {
       clientRepository.save(client);
    }

}
