package com.microservices.core.repository;

import com.microservices.core.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    boolean existsByUsernameAndPassword(String username, String password);

    boolean existsByUsername(String username);

    Optional<Usuario> findByUsername(String username);
}
