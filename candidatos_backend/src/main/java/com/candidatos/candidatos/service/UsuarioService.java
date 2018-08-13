package com.candidatos.candidatos.service;

import com.candidatos.candidatos.persistence.model.Usuario;

import java.util.Optional;

public interface UsuarioService {

    Optional<Usuario> getUsuarioByUserName(String userName);

}
