package com.gonzalo.calculator.service;

import com.gonzalo.calculator.api.model.response.ResultDto;

import java.math.BigDecimal;

public interface CalculatorService {

    ResultDto calculate(String type, BigDecimal firstOperand, BigDecimal secondOperand);
}
