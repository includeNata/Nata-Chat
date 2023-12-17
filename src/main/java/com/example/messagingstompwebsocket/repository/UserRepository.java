package com.example.messagingstompwebsocket.repository;

import com.example.messagingstompwebsocket.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
