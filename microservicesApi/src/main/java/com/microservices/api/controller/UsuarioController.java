package com.microservices.api.controller;

import com.microservices.api.service.UsuarioService;
import com.microservices.core.model.Usuario;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/usuario")
public class UsuarioController {

    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService=usuarioService;
    }

    @Autowired
    PasswordEncoder encoder;

    @PostMapping("/save")
    public ResponseEntity<Object> saveUser(@RequestBody @Valid Usuario user){
        if(usuarioService.existsByUsername(user.getUsername())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Already exist an user with this username");
        }
        user.setPassword(encoder.encode(user.getPassword()));

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginUser(@RequestBody @Valid Usuario user){
        user.setPassword(encoder.encode(user.getPassword()));
        if(usuarioService.existsByUsername(user.getUsername())){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }

        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
