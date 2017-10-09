package ru.techlab.risks.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.techlab.risks.auth.model.AuthUser;
import ru.techlab.risks.auth.model.User;
import ru.techlab.risks.auth.repository.UserRepository;

/**
 * Created by dmitry.erohin@xegex.ru on 29.09.2016.
 * Copyright (C) 2016 - present by Xegex Inc.
 * Please see distribution for license.
 */
@Service
public class AuthUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException(String.format("User with username = %s was not found", username)));
        return new AuthUser(user);
    }
}
