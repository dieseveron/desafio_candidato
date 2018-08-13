package com.candidatos.candidatos.service.serviceImpl;

import com.candidatos.candidatos.persistence.model.Candidato;
import com.candidatos.candidatos.persistence.repository.CandidatoRepository;
import com.candidatos.candidatos.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidatoServiceImpl implements CandidatoService {

    @Autowired
    private CandidatoRepository candidatoRepository;


    @Override
    public List<Candidato> getCandidatos() {
        return candidatoRepository.findAll();
    }

    @Override
    public Optional<Candidato> getCandidatoById(long id) {
        return candidatoRepository.findById(id);
    }

    @Override
    public void createCandidato(Candidato candidato) {
        candidatoRepository.save(candidato);
    }

    @Override
    public void deleteCandidato(long id) {
        candidatoRepository.deleteById(id);
    }

    @Override
    public Candidato update(Candidato candidato) {
        return candidatoRepository.save(candidato);
    }

    @Override
    public Optional<Candidato> getCandidatoByDni(Integer dni) {
        return candidatoRepository.findByDni(dni);
    }

    @Override
    public Optional<Candidato> getCandidatoByNombreYapellido(String nombreYapellido) {
        return candidatoRepository.findByNombreYapellido(nombreYapellido);
    }
}
