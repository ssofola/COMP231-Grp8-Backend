package com.foodistaws.service;

import com.foodistaws.entity.RegisteredUser;
import com.foodistaws.exception.RegisteredUserNotFoundException;
import com.foodistaws.repository.RegisteredUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisteredUserService {
    private final RegisteredUserRepository repository;

    public RegisteredUserService(RegisteredUserRepository repository) {
        this.repository = repository;
    }

    public RegisteredUser create(RegisteredUser newRegisteredUser){
        return repository.save(newRegisteredUser);
    }

    public RegisteredUser readOne(String id){
        return repository.findById(id)
                .orElseThrow(() -> new RegisteredUserNotFoundException(id));
    }

    public List<RegisteredUser> readAll(){
        return repository.findAll();
    }

    public RegisteredUser update(RegisteredUser registeredUser, String id){
        return repository.findById(id)
                .map(user -> {
                    user.setFullName(registeredUser.getFullName());
                    user.setEmail(registeredUser.getEmail());
                    user.setUserName(registeredUser.getUserName());
                    user.setPasswd(registeredUser.getPasswd());
                    user.setRoleID(registeredUser.getRoleID());
                    return repository.save(user);
                }).orElseGet(() -> {
                    registeredUser.setUserID(id);
                    return repository.save(registeredUser);
                });
    }

    public void delete(String id){
        repository.deleteById(id);
    }
}
