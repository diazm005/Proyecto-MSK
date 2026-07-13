package com.dsw2.repository;
import com.dsw2.model.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Optional<Usuario> findByUsername(String username);
}
