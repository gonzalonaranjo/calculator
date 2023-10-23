package com.gonzalo.calculator.factory;

import com.gonzalo.calculator.model.OperationType;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("subtraction")
public class Subtraction implements Operation {
    @Override
    public BigDecimal calculate(BigDecimal firstOperand, BigDecimal secondOperand) {
        return firstOperand.subtract(secondOperand);
    }

    @Override
    public OperationType getType() {
        return OperationType.SUBTRACT;
    }
}
