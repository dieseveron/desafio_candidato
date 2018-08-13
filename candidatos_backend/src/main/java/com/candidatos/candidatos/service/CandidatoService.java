package com.candidatos.candidatos.service;

import com.candidatos.candidatos.persistence.model.Candidato;

import java.util.List;
import java.util.Optional;


public interface CandidatoService {

    List<Candidato> getCandidatos();

    Optional<Candidato> getCandidatoById(long id);

    void createCandidato(Candidato candidato);

    void deleteCandidato(long id);

    Candidato update(Candidato candidato);

    Optional<Candidato> getCandidatoByDni(Integer dni);

    Optional<Candidato> getCandidatoByNombreYapellido(String nombreYapellido);


}
