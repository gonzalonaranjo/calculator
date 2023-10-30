package com.gonzalo.calculator.service;

import com.gonzalo.calculator.api.model.response.ResultDto;
import com.gonzalo.calculator.client.TracerClient;
import com.gonzalo.calculator.factory.Operation;
import com.gonzalo.calculator.factory.OperationFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static com.gonzalo.calculator.api.model.OperationsDto.ADD;
import static com.gonzalo.calculator.api.model.OperationsDto.SUBTRACT;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CalculatorServiceTest {

    @InjectMocks
    private CalculatorServiceImpl service;

    @Mock
    private TracerClient tracerClient;

    @Mock
    private OperationFactory factory;

    @Mock
    private Operation operation;

    @Test
    void calculateAddOperation(){
        BigDecimal expectedResult = new BigDecimal("20");

        whenGetOperationIsCalledThenReturn(expectedResult);
        doNothingWhenTracerIsCalled();

        ResultDto result = service.calculate(ADD, BigDecimal.TEN, BigDecimal.TEN);

       assertAndVerifyResult(generateResultDto(expectedResult), result);
    }

    @Test
    void calculateSubtractOperation() {
        BigDecimal five = new BigDecimal("5");

        whenGetOperationIsCalledThenReturn(five);
        doNothingWhenTracerIsCalled();

        ResultDto result = service.calculate(SUBTRACT, BigDecimal.TEN, five);

        assertAndVerifyResult(generateResultDto(five), result);
    }

    private void whenGetOperationIsCalledThenReturn(BigDecimal expected) {
        when(factory.getOperation(any())).thenReturn(operation);
        when(operation.calculate(any(), any())).thenReturn(expected);
    }

    private void doNothingWhenTracerIsCalled() {
        Mockito.doNothing().when(tracerClient).trace(any());
    }

    private void assertAndVerifyResult(ResultDto expectedResult, ResultDto result) {
        assertThat(result)
                .isEqualTo(expectedResult);
        verify(tracerClient, times(1)).trace(result.result());
    }

    private ResultDto generateResultDto(BigDecimal value) {
        return ResultDto.builder()
                .result(value)
                .build();
    }
}
