package services;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import repositorys.UserRepository;

import java.util.List;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public List<User> findAll (){
        return userRepository.findAll();
    }

    public User findById (Integer id){

        return userRepository.findById(id).get();

    }

    public User create(User user){
        String hash = BCrypt.hashpw(user.getPassword(),BCrypt.gensalt());
        user.setPassword(hash);
        return userRepository.save(user);
    }


    public void delete(Integer id) {
        userRepository.deleteById(id);
    }

}