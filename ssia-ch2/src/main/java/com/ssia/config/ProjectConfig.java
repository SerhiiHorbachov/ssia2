package com.ssia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig {

    @Bean
    UserDetailsService userDetailsService() {
        //Class User in the org.springframework.security.core.userdetails package.
        //It’s the builder implementation we use to create the object to represent the user.
        UserDetails user1 = User.withUsername("John")
                .password("12345")
                .authorities("read")
                .build();

        return new InMemoryUserDetailsManager(user1);
    }

    /**
     * When using the default UserDetailsService, a PasswordEncoder is also auto-configured.
     * Because we overrode UserDetailsService, we also have to declare a PasswordEncoder.
     */
    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }


}
