package com.nuitinfo.repository;

import com.nuitinfo.entity.Surfeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SurfeurRepository  extends JpaRepository<Surfeur,Long> {
}
