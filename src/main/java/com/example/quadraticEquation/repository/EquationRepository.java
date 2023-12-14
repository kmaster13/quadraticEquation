package com.example.quadraticEquation.repository;

import com.example.quadraticEquation.model.EquationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquationRepository extends JpaRepository<EquationModel, Long> {
}