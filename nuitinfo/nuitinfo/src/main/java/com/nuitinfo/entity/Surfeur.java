package com.nuitinfo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "surfeur")
@AllArgsConstructor
@NoArgsConstructor

public class Surfeur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
     private Long id_Surf;

    private String nom;
    private Date dateNaissance ;
    private int tel;

    private String adresse;



}
