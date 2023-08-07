package com.ssia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


/**
 * In earlier versions of Spring Security, a security configuration class needed to extend a class named WebSecurityConfigurerAdapter.
 * We don’t use this practice anymore today.
 */
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
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        //httpBasic() – Calling this method you instructed your app to accept HTTP Basic as an authentication method.
        http.httpBasic(Customizer.withDefaults());//Customizer is a contract you implement to define the customization for either Spring Security element you configure.


        //authorizeHttpRequests() – Calling this method you instructed the app how it should authorize the requests received
        // on specific endpoints
        http.authorizeHttpRequests(customizer -> customizer.anyRequest().permitAll());

        return http.build();
    }


}
