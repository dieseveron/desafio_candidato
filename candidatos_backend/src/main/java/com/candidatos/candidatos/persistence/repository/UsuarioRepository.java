package com.candidatos.candidatos.persistence.repository;


import com.candidatos.candidatos.persistence.model.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

    List<Usuario> findAll();

    Optional<Usuario> findByUsername(String username);
}
