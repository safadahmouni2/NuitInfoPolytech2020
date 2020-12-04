package com.nuitinfo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor

public class Emplacement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id ;
    private String ville ;
    private String pays;
    private String plage;
    private String oceant;

}
