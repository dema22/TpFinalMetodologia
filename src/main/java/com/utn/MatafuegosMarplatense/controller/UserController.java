package com.utn.MatafuegosMarplatense.controller;

import com.utn.MatafuegosMarplatense.models.User;
import com.utn.MatafuegosMarplatense.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{idUser}")
    public Optional<User> getUser(@PathVariable Integer idUser){
        return userService.getOneUser(idUser);
    }

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/")
    public void addUser(@RequestBody User newUser){
        userService.addUser(newUser);
    }

    @DeleteMapping("/{idUser}")
    public void deleteUser(@PathVariable Integer idUser){
        userService.deleteOneUser(idUser);
    }

    @PutMapping("/{idUser}")
    public void updateUser(@RequestBody User user, @PathVariable Integer idUser){
        userService.updateOneUser(user, idUser);
    }
}
