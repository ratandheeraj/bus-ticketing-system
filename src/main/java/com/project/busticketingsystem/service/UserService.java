package com.project.busticketingsystem.service;

import com.project.busticketingsystem.model.User;
import com.project.busticketingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user) {
        List<User> users =  userRepository.findAll();
        for (User u:users) {
            if(Objects.equals(u.getEmail(), user.getEmail())){
                return null;
            }
        }
        return userRepository.save(user);
    }

    public  User authenticateUser(User user){
        List<User> users =  userRepository.findAll();
        for (User u:users) {
            if(Objects.equals(u.getEmail(), user.getEmail())){
                if(Objects.equals(u.getPassword(), user.getPassword())){
                    return u;
                }else{
                    return null;
                }
            }
        }
        return null;
    }
}
