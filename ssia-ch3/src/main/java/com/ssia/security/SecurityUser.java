package com.ssia.security;

import com.ssia.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Avoid mixing responsibilities and try to write your code as decoupled as possible to increase the maintainability
 * of your app.
 *
 * As you can observe, we use the SecurityUser class only to map the user details in the system to the UserDetails
 * contract understood by Spring Security.
 * To mark the fact that the SecurityUser makes no sense without a User entity, we make the field final.
 * You have to provide the user through the constructor. The SecurityUser class decorates the User entity class
 * and adds the needed code related to the Spring Security contract without mixing the code into a JPA entity,
 * thereby implementing multiple different tasks.
 */
public class SecurityUser implements UserDetails {

    private final User user;

    public SecurityUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(user::getAuthority);
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}