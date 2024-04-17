package com.sevilla.clubtor.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sevilla.clubtor.repositories.IUserRepository;

@Service
public class UserService {

    @Autowired
    IUserRepository userRepository;

}
