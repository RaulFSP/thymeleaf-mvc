/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package io.github.thymeleaf_sandbox.authentication;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Administrator
 */
@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private AppUserRepository appUserRepository;

    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> userOpt = appUserRepository.findByUsername(username);
        if (userOpt.isPresent()){
            AppUser user = userOpt.get();
            return User.builder().username(user.getUsername()).password(user.getPassword()).authorities(user.getAuthorities()).build();
        }
        throw new UsernameNotFoundException("User not found: " + username);
    }

}
