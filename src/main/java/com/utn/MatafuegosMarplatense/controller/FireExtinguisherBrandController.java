package com.utn.MatafuegosMarplatense.controller;

import com.utn.MatafuegosMarplatense.models.FireExtinguisherBrand;
import com.utn.MatafuegosMarplatense.services.FireExtinguisherBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fireExtinguisherBrand")

public class FireExtinguisherBrandController {
    private final FireExtinguisherBrandService fireExtinguisherBrandService;

    @Autowired
    public FireExtinguisherBrandController(FireExtinguisherBrandService fireExtinguisherBrandService) {
        this.fireExtinguisherBrandService = fireExtinguisherBrandService;
    }


    @GetMapping("/{idFireExtinguisherBrand}")
    public Optional<FireExtinguisherBrand> getFireExtinguisherBrand(@PathVariable Integer idFireExtinguisherBrand){
        return fireExtinguisherBrandService.getOneFireExtinguisherBrand(idFireExtinguisherBrand);
    }

    @GetMapping("/")
    public List<FireExtinguisherBrand> getAllFireExtinguisherBrands(){
        return fireExtinguisherBrandService.getAllFireExtinguisherBrands();
    }

    @PostMapping("/")
    public void addFireExtinguisherBrand(@RequestBody FireExtinguisherBrand newFireExtinguisherBrand){
        fireExtinguisherBrandService.addFireExtinguisherBrand(newFireExtinguisherBrand);
    }

    @DeleteMapping("/{idFireExtinguisherBrand}")
    public void deleteFireExtinguisherBrand(@PathVariable Integer idFireExtinguisherBrand){
        fireExtinguisherBrandService.deleteOneFireExtinguisherBrand(idFireExtinguisherBrand);
    }

    @PutMapping("/{idFireExtinguisherBrand}")
    public void updateFireExtinguisherBrand(@RequestBody FireExtinguisherBrand fireExtinguisherBrand, @PathVariable Integer idFireExtinguisherBrand){
        fireExtinguisherBrandService.updateOneFireExtinguisherBrand(fireExtinguisherBrand, idFireExtinguisherBrand);
    }
}
