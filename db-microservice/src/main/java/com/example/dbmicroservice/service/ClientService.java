package com.example.dbmicroservice.service;

import com.example.dbmicroservice.model.Client;


import java.util.List;
import java.util.Optional;

public interface ClientService {
   Client getClientById(Long id);


    List<Client> getListOfClients();

    void deleteClientById(Long id);

    void saveClient(Client client);


}
