package com.gonzalo.calculator.service;

import com.gonzalo.calculator.api.model.response.OperationDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static com.gonzalo.calculator.api.model.OperationsResultDto.getOperationDtoSet;

@ExtendWith(MockitoExtension.class)
class OperationServiceTest {

    @InjectMocks
    private OperationServiceImpl service;

    @Test
    void getOperationsReturnsAllOperationList() {
        Set<OperationDto> operations = getOperationDtoSet();

        Set<OperationDto> result = service.getOperations();

        assertThat(result)
                .isEqualTo(operations);
    }
}
