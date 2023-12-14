package com.example.quadraticEquation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EquationDTO {
    private double a;
    private double b;
    private double c;
    private double x1;
    private double x2;

    public EquationDTO(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}