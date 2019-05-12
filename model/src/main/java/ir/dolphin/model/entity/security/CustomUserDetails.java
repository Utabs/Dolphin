package ir.dolphin.model.entity.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomUserDetails extends Users implements UserDetails {

    public CustomUserDetails(Users users) {
        super(users);
    }


    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorities()
                .stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_"+((GrantedAuthority) role).getAuthority()))
                .collect(Collectors.toList());
    }

    public String getUsername() {
        return super.getUserName();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return true;
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }

    @Override
    public Set<Role> getRoles() {
        return super.getRoles();
    }


}
