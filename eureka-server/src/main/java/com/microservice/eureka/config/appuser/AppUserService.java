package com.microservice.eureka.config.appuser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserService implements UserDetailsService {

    private final static String USER_NOT_FOUND = "user with username %s not found";
    private final BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private final AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(BCryptPasswordEncoder passwordEncoder, AppUserRepository appUserRepository) {
        this.passwordEncoder = passwordEncoder;
        this.appUserRepository = appUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return appUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND));
    }
    public String signUpUser(AppUser appUser){
       boolean exists = appUserRepository.findByUsername(appUser.getUsername()).isPresent();
        if (exists){
            throw new IllegalStateException("Username already taken");
        }
        String encode = passwordEncoder.encode(appUser.getPassword());

        appUser.setPassword(encode);

        //TODO: send confirmation token
        appUserRepository.save(appUser);
        return "it works";
    }
}

