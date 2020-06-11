package com.utn.MatafuegosMarplatense.controller;


import com.utn.MatafuegosMarplatense.models.FireExtinguisher;
import com.utn.MatafuegosMarplatense.services.FireExtinguisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fireExtinguisher")

public class FireExtinguisherController {
    private final FireExtinguisherService fireExtinguisherService;

    @Autowired
    public FireExtinguisherController(FireExtinguisherService fireExtinguisherService) {
        this.fireExtinguisherService = fireExtinguisherService;
    }

    // GET ONE FIRE EXTINGUISHER BY ID.
    @GetMapping("/{idFireExtinguisher}")
    public Optional<FireExtinguisher> getFireExtinguisher(@PathVariable Integer idFireExtinguisher){
        return fireExtinguisherService.getOneFireExtinguisher(idFireExtinguisher);
    }

    // GET ALL FIRE EXTINGUISHERS.
    @GetMapping("/")
    public List<FireExtinguisher> getAllFireExtinguishers(){
        return fireExtinguisherService.getAllFireExtinguishers();
    }

    // POST FIRE EXTINGUISHERS.
    @PostMapping("/")
    public void addFireExtinguisher(@RequestBody FireExtinguisher newFireExtinguisher){
        fireExtinguisherService.addFireExtinguisher(newFireExtinguisher);
    }

    // DELETE ONE FIRE EXTINGUISHER BY ID.
    @DeleteMapping("/{idFireExtinguisher}")
    public void deleteFireExtinguisher(@PathVariable Integer idFireExtinguisher){
        fireExtinguisherService.deleteOneFireExtinguisher(idFireExtinguisher);
    }

    // UPDATE FIRE EXTINGUISHER.
    @PutMapping("/{idFireExtinguisher}")
    public void updateUser(@RequestBody FireExtinguisher fireExtinguisher, @PathVariable Integer idFireExtinguisher){
        fireExtinguisherService.updateOneFireExtinguisher(fireExtinguisher, idFireExtinguisher);
    }

}
