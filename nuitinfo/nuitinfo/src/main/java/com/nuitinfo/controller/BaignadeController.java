package com.nuitinfo.controller;

import com.nuitinfo.entity.Baignade;
import com.nuitinfo.exception.ResourceNotFoundException;
import com.nuitinfo.repository.BaignadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("nuitinfo2020/baignade")
public class BaignadeController {
    @Autowired
    private BaignadeRepository baignadeRepository;
    // get all Baignade
    @GetMapping
    public List<Baignade> getAllBaignades() {
        return this.baignadeRepository.findAll();
    }

    // get Baignade by id
    @GetMapping("/{id}")
    public Baignade getBaignadeById(@PathVariable(value = "id") long baignadeId) {
        return this.baignadeRepository.findById(baignadeId)
                .orElseThrow(() -> new ResourceNotFoundException("baignade not found with id :" + baignadeId));
    }

    // create baignade
    @PostMapping
    public Baignade createBaignade(@RequestBody Baignade baignade) {
        return this.baignadeRepository.save(baignade);
    }

    // update Baignade
    @PutMapping("/{id}")
    public Baignade updateBaignade(@RequestBody Baignade baignade, @PathVariable("id") long baignadeId) {
        Baignade existinBaignade= this.baignadeRepository.findById(baignadeId)
                .orElseThrow(() -> new ResourceNotFoundException("baignade not found with id :" + baignadeId));
        existinBaignade.setNom(baignade.getNom());
        existinBaignade.setDateBaingnoire(baignade.getDateBaingnoire());
        existinBaignade.setType(baignade.getType());

        return this.baignadeRepository.save(existinBaignade);
    }

    // delete baignade by id
    @DeleteMapping("/{id}")
    public ResponseEntity< Baignade > deleteBaignade(@PathVariable("id") long baignadeId) {
        Baignade existingBaignade = this.baignadeRepository.findById(baignadeId)
                .orElseThrow(() -> new ResourceNotFoundException("baignade not found with id :" + baignadeId));
        this.baignadeRepository.delete(existingBaignade);
        return ResponseEntity.ok().build();
    }
}
