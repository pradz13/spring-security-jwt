package com.example.jwt.configuration;

import com.example.jwt.entities.UserData;
import com.example.jwt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserData> userInfo = userRepository.findByEmail(username);
        return userInfo
                .map(UserInfoUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found :" + username));

    }
}
