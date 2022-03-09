package com.microservices.api.service;


import com.microservices.core.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    final UsuarioRepository usuarioRepository;

    public  UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository=usuarioRepository;
    }
}
