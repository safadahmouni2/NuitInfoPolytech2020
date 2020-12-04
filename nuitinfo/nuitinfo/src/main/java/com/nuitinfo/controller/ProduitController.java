package com.nuitinfo.controller;

import com.nuitinfo.entity.Produit;
import com.nuitinfo.entity.Surfeur;
import com.nuitinfo.exception.ResourceNotFoundException;
import com.nuitinfo.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("nuitinfo2020/produits")

public class ProduitController {
    @Autowired
    private ProduitRepository produitRepository;
    // get all Produit
    @GetMapping
    public List<Produit> getAllProduits() {
        return this.produitRepository.findAll();
    }

    // get Produit by id
    @GetMapping("/{id}")
    public Produit getProduitById(@PathVariable(value = "id") long produitId) {
        return this.produitRepository.findById(produitId)
                .orElseThrow(() -> new ResourceNotFoundException("produit not found with id :" + produitId));
    }

    // create produit
    @PostMapping
    public Produit createProduit(@RequestBody Produit produit) {
        return this.produitRepository.save(produit);
    }

    // update Produit
    @PutMapping("/{id}")
    public Produit updateProduit(@RequestBody Produit produit, @PathVariable("id") long produitId) {
        Produit existingProduit = this.produitRepository.findById(produitId)
                .orElseThrow(() -> new ResourceNotFoundException("Produit not found with id :" + produitId));
        existingProduit.setNom(produit.getNom());
        existingProduit.setCategorie(produit.getCategorie());

        return this.produitRepository.save(existingProduit);
    }

    // delete produit by id
    @DeleteMapping("/{id}")
    public ResponseEntity< Produit > deleteProduit(@PathVariable("id") long produitId) {
        Produit existingProduit = this.produitRepository.findById(produitId)
                .orElseThrow(() -> new ResourceNotFoundException("Produit not found with id :" + produitId));
        this.produitRepository.delete(existingProduit);
        return ResponseEntity.ok().build();
    }
}
