package com.github.thomasjteixeira.lending.config.security;

import com.github.thomasjteixeira.lending.entity.User;
import com.github.thomasjteixeira.lending.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(username);

        if(user.isPresent()){
            return user.get();
        }

        throw new UsernameNotFoundException("Usuário ou senha incorreta!") ;
    }
}
