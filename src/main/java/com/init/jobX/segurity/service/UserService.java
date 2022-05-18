package com.init.jobX.segurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.init.jobX.segurity.entity.User;
import com.init.jobX.segurity.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<User> getByUserName(String userName){
        return userRepository.findByUsername(userName);
    }

    public boolean existsByNombreUsuario(String userName){
        return userRepository.existsByUsername(userName);
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public User save(User user){
        userRepository.save(user);
        return user;
    }
}