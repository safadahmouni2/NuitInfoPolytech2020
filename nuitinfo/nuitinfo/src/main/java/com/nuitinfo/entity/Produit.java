package com.nuitinfo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor

public class Produit {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id_Prod ;
    private String nom ;
    private String categorie;
}
