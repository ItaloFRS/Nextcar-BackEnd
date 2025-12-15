package com.loja.carros.controller;

import com.loja.carros.dto.AuthenticationDTO;
import com.loja.carros.dto.LoginResponseDTO;
import com.loja.carros.dto.RegisterDTO;
import com.loja.carros.infra.security.TokenService;
import com.loja.carros.model.Usuario;
import com.loja.carros.repository.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((Usuario) auth.getPrincipal());

        Usuario usuario = (Usuario) auth.getPrincipal();

        return ResponseEntity.ok(new LoginResponseDTO(token, usuario.getRole().toString()));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data){
        if(this.repository.findByLogin(data.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        Usuario newUser = new Usuario();
        newUser.setLogin(data.login());
        newUser.setPassword(encryptedPassword);
        newUser.setRole(data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
// Crie records auxiliares DTO para LoginResponseDTO, AuthenticationDTO e RegisterDTO no mesmo pacote ou em um subpacote dto.