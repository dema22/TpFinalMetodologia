package com.utn.MatafuegosMarplatense.services;

import com.utn.MatafuegosMarplatense.models.User;
import com.utn.MatafuegosMarplatense.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getOneUser(Integer idUser) {
        return userRepository.findById(idUser);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public void addUser(User newUser) {
        userRepository.save(newUser);
    }

    public void deleteOneUser(Integer idUser) {
        userRepository.deleteById(idUser);
    }

    public void updateOneUser(User newUser, Integer idUser) {
        Optional<User> resultUSer = getOneUser(idUser);
        User currentUser = resultUSer.get();

        if(resultUSer != null) {
            currentUser.setUserType(newUser.getUserType());
            currentUser.setUsername(newUser.getUsername());
            currentUser.setName(newUser.getName());
            currentUser.setSurname(newUser.getSurname());
            currentUser.setPass(newUser.getPass());
            addUser(currentUser);
        }
    }
}
