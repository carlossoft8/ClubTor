package com.sevilla.clubtor.services;

import com.sevilla.clubtor.models.UserModel;
import com.sevilla.clubtor.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public ResponseEntity<?> login(UserModel user) {
        Optional<UserModel> foundUser = userRepository.findByCorreoElectronico(user.getCorreoElectronico());
        if (foundUser.isPresent() && passwordEncoder.matches(user.getContrasena(), foundUser.get().getContrasena())) {
            return ResponseEntity.ok().body("{\"token\": \"some-generated-token\"}");
        } else {
            return ResponseEntity.status(401).body("{\"message\": \"Correo electrónico o contraseña incorrectos\"}");
        }
    }

    public ResponseEntity<?> register(UserModel user) {
        Optional<UserModel> existingUser = userRepository.findByCorreoElectronico(user.getCorreoElectronico());
        if (existingUser.isPresent()) {
            return ResponseEntity.status(409).body("{\"message\": \"El correo electrónico ya está registrado\"}");
        } else {
            user.setContrasena(passwordEncoder.encode(user.getContrasena()));
            userRepository.save(user);
            return ResponseEntity.ok().body("{\"token\": \"some-generated-token\"}");
        }
    }
}
