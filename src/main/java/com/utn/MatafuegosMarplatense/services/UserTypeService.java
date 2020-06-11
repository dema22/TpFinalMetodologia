package com.utn.MatafuegosMarplatense.services;

import com.utn.MatafuegosMarplatense.models.UserType;
import com.utn.MatafuegosMarplatense.repositories.UserTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserTypeService {
    private final UserTypeRepository userTypeRepository;

    @Autowired
    public UserTypeService(UserTypeRepository userTypeRepository) {
        this.userTypeRepository = userTypeRepository;
    }

    public Optional<UserType> getOneUserType(Integer idUserType) {
        return userTypeRepository.findById(idUserType);
    }

    public List<UserType> getAllUserTypes(){
        return userTypeRepository.findAll();
    }

    public void addUserType(UserType newUserType) {
        userTypeRepository.save(newUserType);
    }

    public void deleteOneUserType(Integer idUserType) {
        userTypeRepository.deleteById(idUserType);
    }
}
