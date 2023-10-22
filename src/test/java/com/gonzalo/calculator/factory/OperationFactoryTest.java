package com.gonzalo.calculator.factory;

import com.gonzalo.calculator.model.OperationType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class OperationFactoryTest {

    @Mock
    private Addition addition;

    @Mock
    private Subtraction subtraction;

    @InjectMocks
    private OperationFactory operationFactory;

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
