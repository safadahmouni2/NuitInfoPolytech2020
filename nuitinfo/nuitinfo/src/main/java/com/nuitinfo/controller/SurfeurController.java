package com.nuitinfo.controller;

import com.nuitinfo.entity.Surfeur;
import com.nuitinfo.exception.ResourceNotFoundException;
import com.nuitinfo.repository.SurfeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("nuitinfo2020/surfeur")


public class SurfeurController {
    @Autowired
    private SurfeurRepository surfeurRepository;


    // get all surfeurs
    @GetMapping
    public List<Surfeur> getAllSurfeurs() {
        return this.surfeurRepository.findAll();
    }

    // get Surfeur by id
    @GetMapping("/{id}")
    public Surfeur getSurfeurById(@PathVariable(value = "id") long surfeurId) {
        return this.surfeurRepository.findById(surfeurId)
                .orElseThrow(() -> new ResourceNotFoundException("surfeur not found with id :" + surfeurId));
    }

    // create Surfeur
    @PostMapping
    public Surfeur createSurfeur(@RequestBody  Surfeur surfeur) {
        return this.surfeurRepository.save(surfeur);
    }

    // update Surfeur
    @PutMapping("/{id}")
    public Surfeur updateSurfeur(@RequestBody Surfeur surfeur, @PathVariable("id") long surfeurId) {
        Surfeur existingSurfeur = this.surfeurRepository.findById(surfeurId)
                .orElseThrow(() -> new ResourceNotFoundException("surfeur not found with id :" + surfeurId));
        existingSurfeur.setNom(surfeur.getNom());
        existingSurfeur.setDateNaissance(surfeur.getDateNaissance());
        existingSurfeur.setAdresse(surfeur.getAdresse());
        existingSurfeur.setTel(surfeur.getTel());

        return this.surfeurRepository.save(existingSurfeur);
    }

    // delete surfeur by id
    @DeleteMapping("/{id}")
    public ResponseEntity< Surfeur > deleteSurfeur(@PathVariable("id") long surfeurId) {
        Surfeur existingSurfeur = this.surfeurRepository.findById(surfeurId)
                .orElseThrow(() -> new ResourceNotFoundException("surfeur not found with id :" + surfeurId));
        this.surfeurRepository.delete(existingSurfeur);
        return ResponseEntity.ok().build();
    }


}
