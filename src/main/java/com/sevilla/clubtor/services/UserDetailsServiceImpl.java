package com.sevilla.clubtor.services;

import com.sevilla.clubtor.models.UserModel;
import com.sevilla.clubtor.repositories.IUserRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String correoElectronico) throws UsernameNotFoundException {
        UserModel user = userRepository.findByCorreoElectronico(correoElectronico)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + correoElectronico));
        return new org.springframework.security.core.userdetails.User(user.getCorreoElectronico(), user.getContrasena(), new ArrayList<>());
    }
}
