package com.gonzalo.calculator.api;

import com.gonzalo.calculator.api.model.response.ResultDto;
import com.gonzalo.calculator.model.OperationType;
import com.gonzalo.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CalculatorControllerTest {

    @InjectMocks
    private CalculatorController controller;

    @Mock
    private CalculatorService service;

    @Test
    void calculateAddOperationReturnsValidResult() {
        BigDecimal firstOperand = BigDecimal.ONE;
        BigDecimal secondOperand = BigDecimal.TEN;
        ResultDto expectedResult = generateResultDto(new BigDecimal("11"));

        whenCalculateIsCalledThenReturn(expectedResult);

        ResponseEntity<ResultDto> result = controller.calculate(OperationType.ADD, firstOperand, secondOperand);

        assertThat(result)
            .extracting(ResponseEntity::getStatusCode, ResponseEntity::getBody)
            .containsExactly(HttpStatus.OK, expectedResult);
    }

    @Test
    void calculateSubtractReturnsValidResult() {
        BigDecimal firstOperand = BigDecimal.TEN;
        BigDecimal secondOperand = BigDecimal.ONE;
        ResultDto expectedResult = generateResultDto(new BigDecimal("9"));

        whenCalculateIsCalledThenReturn(expectedResult);

        ResponseEntity<ResultDto> result = controller.calculate(OperationType.SUBTRACT, firstOperand, secondOperand);

        assertThat(result)
                .extracting(ResponseEntity::getStatusCode, ResponseEntity::getBody)
                .containsExactly(HttpStatus.OK, expectedResult);
    }

    private void whenCalculateIsCalledThenReturn(ResultDto expectedResult) {
        when(service.calculate(any(), any(), any())).thenReturn(expectedResult);
    }

    private ResultDto generateResultDto(BigDecimal value) {
        return ResultDto.builder()
                .result(value)
                .build();
    }

}
