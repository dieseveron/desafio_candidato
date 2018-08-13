package com.candidatos.candidatos.persistence.repository;

import com.candidatos.candidatos.persistence.model.Candidato;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CandidatoRepository extends CrudRepository<Candidato, Long> {

    List<Candidato> findAll();


    Optional<Candidato> findByDni(Integer dni);

    Optional<Candidato> findByNombreYapellido(String nombreYapellido);

}
