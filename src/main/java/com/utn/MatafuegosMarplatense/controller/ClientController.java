package com.utn.MatafuegosMarplatense.controller;

import com.utn.MatafuegosMarplatense.models.Client;
import com.utn.MatafuegosMarplatense.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")

public class ClientController {
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/{idClient}")
    public Optional<Client> getClient(@PathVariable Integer idClient){
        return clientService.getOneClient(idClient);
    }

    @GetMapping("/")
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @PostMapping("/")
    public void addClient(@RequestBody Client newClient){
        clientService.addClient(newClient);
    }

    @DeleteMapping("/{idClient}")
    public void deleteClient(@PathVariable Integer idClient){
        clientService.deleteOneClient(idClient);
    }

    @PutMapping("/{idClient}")
    public void updateClient(@RequestBody Client client, @PathVariable Integer idClient){
        clientService.updateOneClient(client, idClient);
    }
}
