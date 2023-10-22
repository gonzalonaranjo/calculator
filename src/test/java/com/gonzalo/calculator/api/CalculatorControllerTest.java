package com.gonzalo.calculator.api;

import com.gonzalo.calculator.service.CalculatorService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = CalculatorController.class)
class CalculatorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalculatorService service;

    private static final String ADD = "ADD";
    private static final String SUBTRACT = "SUBTRACT";

    @Test
    void calculateWithWrongOperationReturnsBadRequest() throws Exception {
        String operation = "SQRT";
        ResultActions result = calculate(operation, "1", "2");
        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.propertyName", Matchers.equalTo("operationType")))
                .andExpect(jsonPath("$.value", Matchers.equalTo("SQRT")));
    }

    @Test
    void calculateWithNoOperationReturnsNotFound() throws Exception {
        String operation = "";
        ResultActions result = calculate(operation, "1", "2");

        result.andExpect(status().isNotFound());
    }

    @Test
    void calculateWithNoFirstOperandReturnsBadRequest() throws Exception {
        ResultActions result = calculate(ADD, null, "2");

        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.propertyName", Matchers.equalTo("firstOperand")))
                .andExpect(jsonPath("$.value", Matchers.is(null)));
    }

    @Test
    void calculateWithWrongFirstOperandReturnsBadRequest() throws Exception {
        String badFirstOperand = "bad";
        ResultActions result = calculate(ADD, "bad", "2");

        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.propertyName", Matchers.equalTo("firstOperand")))
                .andExpect(jsonPath("$.value", Matchers.is(badFirstOperand)));
    }

    @Test
    void calculateWithNoSecondOperandReturnsBadRequest() throws Exception {
        ResultActions result = calculate(ADD, "1", null);

        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.propertyName", Matchers.equalTo("secondOperand")))
                .andExpect(jsonPath("$.value", Matchers.is(null)));
    }

    @Test
    void calculateWithWrongSecondOperandReturnsBadRequest() throws Exception {
        String badSecondOperand = "bad";
        ResultActions result = calculate(ADD, "1", badSecondOperand);

        result.andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.propertyName", Matchers.equalTo("secondOperand")))
                .andExpect(jsonPath("$.value", Matchers.is(badSecondOperand)));
    }

    @Test
    void calculateAddOperationReturnsValidResult() throws Exception {
        String firstOperand = "1";
        String secondOperand = "10";
        BigDecimal expectedResult = new BigDecimal("11");

        whenCalculateIsCalledThenReturn(expectedResult);

        ResultActions result = calculate(ADD, firstOperand, secondOperand);
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.equalTo(expectedResult.intValue())));

    }

    @Test
    void calculateSubtractReturnsValidResult() throws Exception {
        String firstOperand = "10";
        String secondOperand = "1";
        BigDecimal expectedResult = new BigDecimal("9");

        whenCalculateIsCalledThenReturn(expectedResult);

        ResultActions result = calculate(SUBTRACT, firstOperand, secondOperand);
        result.andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.equalTo(expectedResult.intValue())));
    }

    private void whenCalculateIsCalledThenReturn(BigDecimal expectedResult) {
        when(service.calculate(any(), any(), any())).thenReturn(expectedResult);
    }

    private ResultActions calculate(
            String operationType, String firstOperand, String secondOperand) throws Exception {

        String URL = "/api/v1/calculator/{operationType}";
        return mockMvc.perform(MockMvcRequestBuilders.get(URL, operationType)
                .param("firstOperand", firstOperand)
                .param("secondOperand", secondOperand));
    }
}
