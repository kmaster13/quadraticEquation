package com.example.quadraticEquation.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class EquationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double a;
    private double b;
    private double c;
    private double x1;
    private double x2;

    public EquationModel(double a, double b, double c, double x1, double x2) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.x1 = x1;
        this.x2 = x2;
    }

    public EquationModel(double a, double b, double c, double x1) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.x1 = x1;
    }
}