package com.gonzalo.calculator.client;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class TracerClientTest {

    @Mock
    private TracerClient client;

    @Test
    void testTraceMessage() {
        String message = "message";

        client.trace(message);

        verify(client).trace(message);
    }
}
