package com.microservices.api.service;


import com.microservices.core.model.Usuario;
import com.microservices.core.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UsuarioService {

    final UsuarioRepository usuarioRepository;

    public  UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }

    @Transactional
    public Usuario save(Usuario user){
        return usuarioRepository.save(user);
    }

    public boolean existsByUsername(String username){
        return usuarioRepository.existsByUsername(username);
    }

    public boolean existsByUsernameAndPassword(String username, String password){
        return usuarioRepository.existsByUsernameAndPassword(username,password);
    }

    public Optional<Usuario> findByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }
}
