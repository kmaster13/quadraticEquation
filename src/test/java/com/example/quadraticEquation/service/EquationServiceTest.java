package com.example.quadraticEquation.service;

import com.example.quadraticEquation.dto.EquationDTO;
import com.example.quadraticEquation.model.EquationModel;
import com.example.quadraticEquation.repository.EquationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EquationServiceTest {

    @Mock
    private EquationRepository equationRepository;

    @InjectMocks
    private EquationService equationService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void solveEquation_WithRealRoots_ShouldReturnRoots() {
        EquationDTO equation = new EquationDTO(1, -3, 2);
        EquationModel expectedResult = new EquationModel(1, -3, 2, 2, 1);

        ResponseEntity<?> expectedResponse = ResponseEntity.ok().body(Map.of("x1", 2.0, "x2", 1.0));

        when(equationRepository.save(any())).thenReturn(expectedResult);

        ResponseEntity<?> actualResponse = equationService.solveEquation(equation);

        assertEquals(expectedResponse, actualResponse);
        verify(equationRepository, times(1)).save(any());
    }

    @Test
    public void solveEquation_WithRealRoots_AnotherVersion_ShouldReturnRoots() {
        EquationDTO equation = new EquationDTO(1, 2, 1);
        EquationModel expectedResult = new EquationModel(1, 2, 1, -1);

        ResponseEntity<?> expectedResponse = ResponseEntity.ok(Map.of("x", -1.0));

        when(equationRepository.save(any())).thenReturn(expectedResult);

        ResponseEntity<?> actualResponse = equationService.solveEquation(equation);

        assertEquals(expectedResponse, actualResponse);
        verify(equationRepository, times(1)).save(any());
    }

    @Test
    public void solveEquation_WithNoRealRoots_ShouldReturnErrorMessage() {
        EquationDTO equation = new EquationDTO(1, 2, 3);

        ResponseEntity<?> expectedResponse = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Корни не могут быть найдены!");

        ResponseEntity<?> actualResponse = equationService.solveEquation(equation);

        assertEquals(expectedResponse, actualResponse);
        verify(equationRepository, never()).save(any());
    }
}