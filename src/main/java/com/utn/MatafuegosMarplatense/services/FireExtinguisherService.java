package com.utn.MatafuegosMarplatense.services;

import com.utn.MatafuegosMarplatense.models.FireExtinguisher;
import com.utn.MatafuegosMarplatense.repositories.FireExtinguisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FireExtinguisherService {

    private final FireExtinguisherRepository fireExtinguisherRepository;

    @Autowired
    public FireExtinguisherService(FireExtinguisherRepository fireExtinguisherRepository) {
        this.fireExtinguisherRepository = fireExtinguisherRepository;
    }

    public Optional<FireExtinguisher> getOneFireExtinguisher(Integer idFireExtinguisher) {
        return fireExtinguisherRepository.findById(idFireExtinguisher);
    }

    public List<FireExtinguisher> getAllFireExtinguishers(){
        return fireExtinguisherRepository.findAll();
    }

    public void addFireExtinguisher(FireExtinguisher newFireExtinguisher) {
        fireExtinguisherRepository.save(newFireExtinguisher);
    }

    public void deleteOneFireExtinguisher(Integer idFireExtinguisher) {
        fireExtinguisherRepository.deleteById(idFireExtinguisher);
    }

    public void updateOneFireExtinguisher(FireExtinguisher newFireExtinguisher, Integer idFireExtinguisher) {
        Optional<FireExtinguisher> resultFireExtinguisher = getOneFireExtinguisher(idFireExtinguisher);
        FireExtinguisher currentFireExtinguisher = resultFireExtinguisher.get();

        if(resultFireExtinguisher != null) {
            currentFireExtinguisher.setClient(newFireExtinguisher.getClient());
            currentFireExtinguisher.setFireExtinguisherBrand(newFireExtinguisher.getFireExtinguisherBrand());
            currentFireExtinguisher.setFireExtinguishingAgent(newFireExtinguisher.getFireExtinguishingAgent());
            currentFireExtinguisher.setFireExtinguisherCapacity(newFireExtinguisher.getFireExtinguisherCapacity());
            currentFireExtinguisher.setDateFabrication(newFireExtinguisher.getDateFabrication());
            currentFireExtinguisher.setLoadingDate(newFireExtinguisher.getLoadingDate());
            currentFireExtinguisher.setDateHydraulicTest(newFireExtinguisher.getDateHydraulicTest());
            currentFireExtinguisher.setBarcode(newFireExtinguisher.getBarcode());
            currentFireExtinguisher.setCertificacionBureauBeritas(newFireExtinguisher.getCertificacionBureauBeritas());

            // When we call add user method we will use the save JPA method which will update BECAUSE
            // the method is based on id value, if an id exists it merge (updated) the entity otherwise
            // it will save a new entity.

            addFireExtinguisher(currentFireExtinguisher);
        }
    }

    public List<FireExtinguisher> getAllFireExtinguishersByIdClient(Integer idClient) {
        return fireExtinguisherRepository.getAllFireExtinguishersById(idClient);
    }
}
