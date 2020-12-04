package com.nuitinfo.repository;

import com.nuitinfo.entity.Baignade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaignadeRepository extends JpaRepository<Baignade,Long> {
}
