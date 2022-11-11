package com.microservice.eureka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private final UserDetailServiceImpl detailsData;

    private final PasswordEncoder passwordEncoder;

    @Value("${app.eureka.username}")
    private String username;
    @Value("${app.eureka.password}")
    private String password;

    public SecurityConfig(UserDetailServiceImpl detailsData, PasswordEncoder passwordEncoder) {
        this.detailsData = detailsData;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(detailsData).passwordEncoder(passwordEncoder());
                /*.inMemoryAuthentication()
                .passwordEncoder()
                .withUser(username).password(password)
                .authorities("USER");*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
}
