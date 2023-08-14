package com.ssia.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Avoid mixing responsibilities and try to write your code as decoupled as possible to increase the maintainability
 * of your app.
 * <p>
 * As you can observe, we use the SecurityUser class only to map the user details in the system to the UserDetails
 * contract understood by Spring Security.
 * To mark the fact that the SecurityUser makes no sense without a User entity, we make the field final.
 * You have to provide the user through the constructor. The SecurityUser class decorates the User entity class
 * and adds the needed code related to the Spring Security contract without mixing the code into a JPA entity,
 * thereby implementing multiple different tasks.
 */
public class SecurityUser implements UserDetails {

    private final String username;
    private final String password;
    private final String authority;

    public SecurityUser(String username, String password, String authority) {
        this.username = username;
        this.password = password;
        this.authority = authority;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
