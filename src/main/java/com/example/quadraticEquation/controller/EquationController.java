package com.example.quadraticEquation.controller;

import com.example.quadraticEquation.dto.EquationDTO;
import com.example.quadraticEquation.service.EquationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equation")
@RequiredArgsConstructor
public class EquationController {
    private final EquationService equationService;

    @PostMapping("/solve")
    public ResponseEntity<?> solveEquation(@RequestBody EquationDTO equation) {
        return equationService.solveEquation(equation);
    }
}