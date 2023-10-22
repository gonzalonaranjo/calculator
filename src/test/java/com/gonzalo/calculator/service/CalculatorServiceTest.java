package com.gonzalo.calculator.service;

import com.gonzalo.calculator.client.TracerClient;
import com.gonzalo.calculator.model.OperationType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {

    @InjectMocks
    private CalculatorServiceImpl service;

    @InjectMocks
    private TracerClient tracerClient;

    @Test
    void calculateAddOperation(){
        BigDecimal expectedResult = new BigDecimal("20");

        doNothingWhenTracerIsCalled();

        BigDecimal result = service.calculate(OperationType.ADD, BigDecimal.TEN, BigDecimal.TEN);

        assertAndVerifyResult(expectedResult, result);
    }

    @Test
    void calculateSubtractOperation() {
        BigDecimal five = new BigDecimal("5");

        doNothingWhenTracerIsCalled();

        BigDecimal result = service.calculate(OperationType.SUBTRACT, BigDecimal.TEN, five);

        assertAndVerifyResult(five, result);
    }

    private void doNothingWhenTracerIsCalled() {
        Mockito.doNothing().when(tracerClient).trace(any());
    }

    private void assertAndVerifyResult(BigDecimal expectedResult, BigDecimal result) {
        assertThat(result)
                .isEqualTo(expectedResult);
        verify(tracerClient, times(1)).trace(result);
    }
}
