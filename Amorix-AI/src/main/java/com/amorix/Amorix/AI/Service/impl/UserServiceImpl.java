package com.amorix.Amorix.AI.Service.impl;

import com.amorix.Amorix.AI.Dto.Auth.Response.ProfileResponseDto;
import com.amorix.Amorix.AI.Errors.ResourceNotFoundException;
import com.amorix.Amorix.AI.Repository.UserRepository;
import com.amorix.Amorix.AI.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public ProfileResponseDto getProfile() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new ResourceNotFoundException("User", username));
    }
}
