package com.candidatos.candidatos.service.serviceImpl;

import com.candidatos.candidatos.persistence.model.Usuario;
import com.candidatos.candidatos.persistence.repository.UsuarioRepository;
import com.candidatos.candidatos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public Optional<Usuario> getUsuarioByUserName(String userName) {
        return usuarioRepository.findByUsername(userName);
    }


}
