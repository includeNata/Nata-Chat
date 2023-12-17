package com.example.messagingstompwebsocket.services;

import com.example.messagingstompwebsocket.entities.User;
import com.example.messagingstompwebsocket.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServices {
    @Autowired
    private UserRepository userRepository;


    public List<User> findAll (){
        return userRepository.findAll();
    }

    public User findById (Integer id){
        return userRepository.findById(id).get();

    }

    public User create(User user){
        return userRepository.save(user);
    }


    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

}
