package com.example.messagingstompwebsocket.controller;

import com.example.messagingstompwebsocket.entities.User;
import com.example.messagingstompwebsocket.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserServices userServices;

    @GetMapping
    public List<User> findAll (){
        return userServices.findAll();
    }

    @PostMapping("/{id}")
    public User findById (@PathVariable Integer id){
        return userServices.findById(id);
    }

    @PostMapping
    public User create(@RequestBody User user){
        return userServices.create(user);
    }

    @PutMapping
    public User put(@RequestBody User user){
        User aux = userServices.findById(user.getId());
        LocalDate data = aux.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate data2 = user.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        if (aux.getName().equals(user.getName()) && data.equals(data2))
        {
            return userServices.create(user);
        }


        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        userServices.delete(id);
    }
}
