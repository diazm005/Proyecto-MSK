package com.dsw2.controller;

import com.dsw2.model.Usuario;
import com.dsw2.repository.UsuarioRepository;
import com.dsw2.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioRepository repo;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder encoder;

    public AuthController(UsuarioRepository repo, JwtUtil jwtUtil, PasswordEncoder encoder) {
        this.repo = repo;
        this.jwtUtil = jwtUtil;
        this.encoder = encoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");

        return repo.findByUsername(username)
                .filter(u -> encoder.matches(password, u.getPassword()))
                .map(u -> ResponseEntity.ok(Map.of("token", jwtUtil.generateToken(u.getUsername()))))
                .orElse(ResponseEntity.status(401).build());
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Usuario u) {
        u.setPassword(encoder.encode(u.getPassword()));
        return ResponseEntity.ok(repo.save(u));
    }
}