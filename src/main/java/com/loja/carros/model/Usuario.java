package com.loja.carros.model;

import lombok.Data; // Cria Getters/Setters automáticos
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Document(collection = "usuarios")
@Data
public class Usuario implements UserDetails {
    @Id
    private String id;
    private String login; // email
    private String password; // senha hash
    private String role; // ex: ADMIN, USER

    // Métodos obrigatórios do UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Normaliza para maiúsculo antes de verificar
        if (this.role != null && this.role.toUpperCase().equals("ADMIN")) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }

    @Override public String getUsername() { return login; }
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}