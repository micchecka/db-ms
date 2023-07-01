package com.example.dbmicroservice.controler;

import com.example.dbmicroservice.model.Client;
import com.example.dbmicroservice.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientController")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping()
    public ResponseEntity<List<Client>> getAllClients() {
        List<Client> clients = clientService.getListOfClients();
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable("id") Long id) {
        return ResponseEntity.ok(clientService.getClientById(id));
    }


    @PostMapping("/newClient")
    public ResponseEntity<Client> createClient(@RequestBody Client client) {
        clientService.saveClient(client);
        return ResponseEntity.ok(client);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable("id") Long id) {
        clientService.deleteClientById(id);
        return ResponseEntity.ok().build();
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id,
                                               @RequestBody Client client) {
        Client editedClient = clientService.getClientById(id);
        editedClient.setFirstName(client.getFirstName());
        editedClient.setLastName(client.getLastName());
        editedClient.setBirthDate(client.getBirthDate());
        editedClient.setPhone(client.getPhone());
        editedClient.setEmail(client.getEmail());
        clientService.saveClient(client);
        return ResponseEntity.ok(clientService.getClientById(id));
    }

}
