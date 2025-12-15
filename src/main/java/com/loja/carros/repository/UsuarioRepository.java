package com.loja.carros.repository;

import com.loja.carros.model.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    UserDetails findByLogin(String login);
}