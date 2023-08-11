package com.ssia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootApplication
public class SsiaCh3Application {

    public static void main(String[] args) {
        SpringApplication.run(SsiaCh3Application.class, args);

//Using a builder to create instances of The UserDetails type.
/*
        UserDetails u = User.withUsername("bill")
                .password("12345")
                .authorities("read", "write")
                .accountExpired(false)
                .disabled(true)
                .build();

        User.UserBuilder builder1 = User.withUsername("bill");

        UserDetails u1 = builder1
                .password("12345")
                .authorities("read", "write")
                .passwordEncoder(p -> encode(p))
                .accountExpired(false)
                .disabled(true)
                .build();

        User.UserBuilder builder2 = User.withUserDetails(u);
        UserDetails u2 = builder2.build();
 */
    }

}
