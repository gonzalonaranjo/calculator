package com.gonzalo.calculator.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static com.gonzalo.calculator.api.model.OperationsDto.ADD;
import static com.gonzalo.calculator.api.model.OperationsDto.SUBTRACT;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class OperationFactoryTest {

    @Mock
    private Addition addition;

    @Mock
    private Subtraction subtraction;

    private OperationFactory operationFactory;

    @BeforeEach
    void setUp() {
        Set<Operation> operations = Set.of(addition, subtraction);
        operationFactory = new OperationFactory(operations);
    }

    @Test
    void getADDTypeReturnsAdditionInstance() {

        Operation operation = operationFactory.getOperation(ADD);

        assertThat(operation)
                .isEqualTo(addition);
    }

    @Test
    void getSubtractTypeReturnsSubtractionInstance() {

        Operation operation = operationFactory.getOperation(SUBTRACT);

        assertThat(operation)
                .isEqualTo(subtraction);
    }

    @Test
    void getOperationTypesReturnsAllOperationTypesInTheCalculator() {

        Set<String> expectedOperations = Set.of(ADD, SUBTRACT);

        Set<String> operationSet = operationFactory.getOperationTypes();

        assertThat(expectedOperations)
                .isEqualTo(operationSet);
    }
}
