package com.gonzalo.calculator.service;

import com.gonzalo.calculator.api.model.response.OperationDto;
import com.gonzalo.calculator.factory.OperationFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static com.gonzalo.calculator.api.model.OperationsDto.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OperationServiceTest {

    @Mock
    private OperationFactory factory;

    @InjectMocks
    private OperationServiceImpl service;

    @Test
    void getOperationsReturnsAllOperationSet() {
        Set<OperationDto> operations = getOperationDtoSet();

        when(factory.getOperationTypes()).thenReturn(Set.of(ADD, SUBTRACT));

        Set<OperationDto> result = service.getOperations();

        assertThat(result)
                .isEqualTo(operations);
    }
}
