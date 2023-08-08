package com.ssia.config;

import com.ssia.security.CustomAuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;


/**
 * In earlier versions of Spring Security, a security configuration class needed to extend a class named WebSecurityConfigurerAdapter.
 * We don’t use this practice anymore today.
 *
 * Any of these configuration options are correct. The first option, where we add the beans to the context,
 * lets you inject the values in another class where you might potentially need them.
 * But if you don’t need that for your case, the second option would be equally good.
 */
@Configuration
public class ProjectConfig {

    private final CustomAuthenticationProvider authenticationProvider;

    public ProjectConfig(CustomAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
        //httpBasic() – Calling this method you instructed your app to accept HTTP Basic as an authentication method.
        http.httpBasic(Customizer.withDefaults());//Customizer is a contract you implement to define the customization for either Spring Security element you configure.

        http.authenticationProvider(authenticationProvider);
        //authorizeHttpRequests() – Calling this method you instructed the app how it should authorize the requests received
        // on specific endpoints
        http.authorizeHttpRequests(customizer -> customizer.anyRequest().authenticated());

        return http.build();
    }


}
