package com.gonzalo.calculator.factory;

import com.gonzalo.calculator.model.OperationType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OperationFactoryTest {

    @Mock
    private Addition addition;

    @Mock
    private Subtraction subtraction;

    private OperationFactory operationFactory;

    @BeforeEach
    void setUp() {
        when(addition.getType()).thenReturn(OperationType.ADD);
        when(subtraction.getType()).thenReturn(OperationType.SUBTRACT);
        Set<Operation> operations = Set.of(addition, subtraction);
        operationFactory = new OperationFactory(operations);
    }

    @Test
    void getADDTypeReturnsAdditionInstance() {

        Operation operation = operationFactory.getOperation(OperationType.ADD);

        assertThat(operation)
                .isEqualTo(addition);
    }

    @Test
    void getSubtractTypeReturnsSubtractionInstance() {

        Operation operation = operationFactory.getOperation(OperationType.SUBTRACT);

        assertThat(operation)
                .isEqualTo(subtraction);
    }
}
