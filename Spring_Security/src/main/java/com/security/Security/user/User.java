package com.security.Security.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {

    @Id
    @GeneratedValue // default value is auto
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING) // Use EnumType.STRING to persist the role field as a string in the database
    private Role role;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));          // Returns a collection of GrantedAuthority objects representing the user's role
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        // Indicates whether the user account is expired
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // Indicates whether the user account is locked
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // Indicates whether the user's credentials (e.g., password) are expired
        return true;
    }

    @Override
    public boolean isEnabled() {
        // Indicates whether the user account is enabled
        return true;
    }
}
