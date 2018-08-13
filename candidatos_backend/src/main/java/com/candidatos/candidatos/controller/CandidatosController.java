package com.candidatos.candidatos.controller;

import com.candidatos.candidatos.exception.CandidatoMismatchException;
import com.candidatos.candidatos.exception.CandidatoNotFoundException;
import com.candidatos.candidatos.persistence.model.Candidato;
import com.candidatos.candidatos.service.CandidatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/candidatos")
public class CandidatosController {

    @Autowired
    private CandidatoService candidatoService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Candidato> findAll(){
         return candidatoService.getCandidatos();
    }

    @RequestMapping(path = "{id}",method = RequestMethod.GET)
    public Candidato findOne(@PathVariable(value = "id") Long id) {
        return candidatoService.getCandidatoById(id)
                .orElseThrow(CandidatoNotFoundException::new);
    }


    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public void create(@RequestBody Candidato candidato) {
        candidatoService.createCandidato(candidato);

    }

    @RequestMapping(path = "{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) {
        candidatoService.getCandidatoById(id)
                .orElseThrow(CandidatoNotFoundException::new);
        candidatoService.deleteCandidato(id);
    }

    @PutMapping("/{id}")
    public Candidato updateDocument(@RequestBody Candidato candidato, @PathVariable long id) {
        if (candidato.getId() != id) {
            throw new CandidatoMismatchException();
        }
        candidatoService.getCandidatoById(id)
                .orElseThrow(CandidatoNotFoundException::new);
        return candidatoService.update(candidato);
    }

    @RequestMapping(path = "/dni/{dni}",method = RequestMethod.GET)
    public Optional<Candidato> findByDni(@PathVariable(value = "dni") Integer dni){
        return candidatoService.getCandidatoByDni(dni);
    }

    @RequestMapping(path = "/nombreyapellido/{nombreYapellido}",method = RequestMethod.GET)
    public Optional<Candidato> findByNombre(@PathVariable(value = "nombreYapellido") String nombreYapellido){
        return candidatoService.getCandidatoByNombreYapellido(nombreYapellido);
    }
}
