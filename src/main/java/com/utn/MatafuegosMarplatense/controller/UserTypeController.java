package com.utn.MatafuegosMarplatense.controller;

import com.utn.MatafuegosMarplatense.models.UserType;
import com.utn.MatafuegosMarplatense.services.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/userType")
public class UserTypeController {
    private final UserTypeService userTypeService;

    @Autowired
    public UserTypeController(UserTypeService userTypeService) {
        this.userTypeService = userTypeService;
    }

    @GetMapping("/{idUserType}")
    public Optional<UserType> getUserType(@PathVariable Integer idUserType){
        return userTypeService.getOneUserType(idUserType);
    }

    @GetMapping("/")
    public List<UserType> getAllUserTypes(){
        return userTypeService.getAllUserTypes();
    }

    @PostMapping("/")
    public void addUserType(@RequestBody UserType newUserType){
        userTypeService.addUserType(newUserType);
    }

    @DeleteMapping("/{idUserType}")
    public void deleteUserType(@PathVariable Integer idUserType){
        userTypeService.deleteOneUserType(idUserType);
    }
}
