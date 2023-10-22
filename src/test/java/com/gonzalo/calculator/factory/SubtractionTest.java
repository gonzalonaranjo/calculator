package com.gonzalo.calculator.factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class SubtractionTest {

    @InjectMocks
    private Subtraction subtraction;

    @Test
    void addCalculateReturnsTheSumOfBothOperands() {
        BigDecimal firstOperand = new BigDecimal("5");
        BigDecimal secondOperand = new BigDecimal("3");
        BigDecimal expectedResult = new BigDecimal("2");

        BigDecimal result = subtraction.calculate(firstOperand, secondOperand);

        assertThat(expectedResult)
                .isEqualTo(result);
    }
}
