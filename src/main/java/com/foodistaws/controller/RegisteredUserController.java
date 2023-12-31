package com.foodistaws.controller;

import com.foodistaws.entity.RegisteredUser;
import com.foodistaws.service.RegisteredUserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class RegisteredUserController {
    final
    RegisteredUserService registeredUserService;

    public RegisteredUserController(RegisteredUserService registeredUserService) {
        this.registeredUserService = registeredUserService;
    }

    @PostMapping
    RegisteredUser createRegisteredUser(@RequestBody RegisteredUser newRegisteredUser){
        return registeredUserService.create(newRegisteredUser);
    }

    @GetMapping("/{id}")
    RegisteredUser readOneRegisteredUser(@PathVariable String id){
        return registeredUserService.readOne(id);
    }

    @GetMapping("/")
    List<RegisteredUser> readAllRegisteredUser(){
        return registeredUserService.readAll();
    }

    @PutMapping("/{id}")
    RegisteredUser updateRegisteredUser(@RequestBody RegisteredUser registeredUser, @PathVariable String id){
        return registeredUserService.update(registeredUser,id);
    }

    @DeleteMapping("/{id}")
    void deleteRegisteredUser(@PathVariable String id){
        registeredUserService.delete(id);
    }
}
