package com.example.quadraticEquation.service;

import com.example.quadraticEquation.dto.EquationDTO;
import com.example.quadraticEquation.model.EquationModel;
import com.example.quadraticEquation.repository.EquationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Map;

@Service
@RequiredArgsConstructor
public class EquationService {
    private final EquationRepository equationRepository;

    public ResponseEntity<?> solveEquation(EquationDTO equationDTO) {
        double a = equationDTO.getA();
        double b = equationDTO.getB();
        double c = equationDTO.getC();

        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double sqrtDiscriminant = Math.sqrt(discriminant);
            double x1 = (-b + sqrtDiscriminant) / (2 * a);
            double x2 = (-b - sqrtDiscriminant) / (2 * a);

            equationRepository.save(new EquationModel(a, b, c, x1, x2));
            return ResponseEntity.ok(Map.of("x1", x1, "x2", x2));
        } else if (discriminant == 0) {
            double x = -b / (2 * a);

            equationRepository.save(new EquationModel(a, b, c, x));
            return ResponseEntity.ok(Map.of("x", x));
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Корни не могут быть найдены!");
        }
    }
}