package com.sevilla.clubtor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sevilla.clubtor.models.UserModel;
import com.sevilla.clubtor.repositories.IUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<UserModel> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public UserModel createUser(UserModel user) {
        user.setContrasena(passwordEncoder.encode(user.getContrasena()));
        return userRepository.save(user);
    }

    public UserModel updateUser(Long userId, UserModel userDetails) {
        userDetails.setId(userId);
        if (userDetails.getContrasena() != null) {
            userDetails.setContrasena(passwordEncoder.encode(userDetails.getContrasena()));
        }
        return userRepository.save(userDetails);
    }

    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    public Optional<UserModel> getUserByEmail(String email) {
        return userRepository.findByCorreoElectronico(email);
    }
}
