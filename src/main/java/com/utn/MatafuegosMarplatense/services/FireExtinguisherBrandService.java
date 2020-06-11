package com.utn.MatafuegosMarplatense.services;

import com.utn.MatafuegosMarplatense.models.FireExtinguisherBrand;
import com.utn.MatafuegosMarplatense.repositories.FireExtinguisherBrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FireExtinguisherBrandService {
    private final FireExtinguisherBrandRepository fireExtinguisherBrandRepository;

    @Autowired
    public FireExtinguisherBrandService(FireExtinguisherBrandRepository fireExtinguisherBrandRepository) {
        this.fireExtinguisherBrandRepository = fireExtinguisherBrandRepository;
    }

    public Optional<FireExtinguisherBrand> getOneFireExtinguisherBrand(Integer idFireExtinguisherBrand) {
        return fireExtinguisherBrandRepository.findById(idFireExtinguisherBrand);
    }

    public List<FireExtinguisherBrand> getAllFireExtinguisherBrands(){
        return fireExtinguisherBrandRepository.findAll();
    }

    public void addFireExtinguisherBrand(FireExtinguisherBrand fireExtinguisherBrand) {
        fireExtinguisherBrandRepository.save(fireExtinguisherBrand);
    }

    public void deleteOneFireExtinguisherBrand(Integer idFireExtinguisherBrand) {
        fireExtinguisherBrandRepository.deleteById(idFireExtinguisherBrand);
    }

    public void updateOneFireExtinguisherBrand(FireExtinguisherBrand newFireExtinguisherBrand, Integer idFireExtinguisherBrand) {
        Optional<FireExtinguisherBrand> resultFireExtinguisherBrand = getOneFireExtinguisherBrand(idFireExtinguisherBrand);
        FireExtinguisherBrand currentFireExtinguisherBrand = resultFireExtinguisherBrand.get();

        if(resultFireExtinguisherBrand != null) {
            currentFireExtinguisherBrand.setBrandName(newFireExtinguisherBrand.getBrandName());
            addFireExtinguisherBrand(currentFireExtinguisherBrand);
        }
    }
}
