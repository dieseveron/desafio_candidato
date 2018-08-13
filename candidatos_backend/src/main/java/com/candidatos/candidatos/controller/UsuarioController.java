package com.candidatos.candidatos.controller;

import com.candidatos.candidatos.persistence.model.Usuario;
import com.candidatos.candidatos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/login")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(path = "{username}",method = RequestMethod.GET)
    public Optional<Usuario> findByName(@PathVariable(value = "username") String username){

        return usuarioService.getUsuarioByUserName(username);
    }
}
