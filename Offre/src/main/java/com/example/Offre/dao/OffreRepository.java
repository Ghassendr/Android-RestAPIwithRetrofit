package com.example.Offre.dao;

import com.example.Offre.entity.Offre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffreRepository extends JpaRepository <Offre , Integer> {
}
