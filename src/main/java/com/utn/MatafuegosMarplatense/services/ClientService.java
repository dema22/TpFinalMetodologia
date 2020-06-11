package com.utn.MatafuegosMarplatense.services;

import com.utn.MatafuegosMarplatense.dtos.FireExtinguisherDTO;
import com.utn.MatafuegosMarplatense.models.Client;
import com.utn.MatafuegosMarplatense.models.FireExtinguisher;
import com.utn.MatafuegosMarplatense.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private final ClientRepository clientRepository;
    private final FireExtinguisherService fireExtinguisherService;

    @Autowired
    public ClientService(ClientRepository clientRepository, FireExtinguisherService fireExtinguisherService) {
        this.clientRepository = clientRepository;
        this.fireExtinguisherService = fireExtinguisherService;
    }

    public Optional<Client> getOneClient(Integer idClient) {
        Optional<Client> client = clientRepository.findById(idClient);
        Client currentClient = client.get();

        if(client != null) {
            List<FireExtinguisher> listFireExtinguishers = fireExtinguisherService.getAllFireExtinguishersByIdClient(idClient);
            List<FireExtinguisherDTO> listFireExtinguishersDTO = new ArrayList<>();

            for(FireExtinguisher e: listFireExtinguishers){
                listFireExtinguishersDTO.add(new FireExtinguisherDTO(e.getFireExtinguisherBrand(),e.getFireExtinguishingAgent(),
                        e.getFireExtinguisherCapacity(), e.getDateFabrication(), e.getLoadingDate(), e.getDateHydraulicTest(), e.getBarcode(),e.getCertificacionBureauBeritas()));
            }

            currentClient.setClientFireExtinguishers(listFireExtinguishersDTO);
        }

        Optional<Client> newClientOptional = Optional.of(currentClient);

        return newClientOptional;
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public void addClient(Client newClient) {
        clientRepository.save(newClient);
    }

    public void deleteOneClient(Integer idClient) {
        clientRepository.deleteById(idClient);
    }

    public void updateOneClient(Client newClient, Integer idClient) {
        Optional<Client> resultClient = getOneClient(idClient);
        Client currentClient = resultClient.get();

        if(resultClient != null) {
            currentClient.setClientName(newClient.getClientName());
            currentClient.setCity(newClient.getCity());
            currentClient.setContactNumber(newClient.getContactNumber());
            addClient(currentClient);
        }
    }
}
