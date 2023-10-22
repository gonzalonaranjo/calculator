package com.gonzalo.calculator.factory;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Subtraction implements Operation {
    @Override
    public BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand) {
        return firstOperand.subtract(secondOperand);
    }
}
