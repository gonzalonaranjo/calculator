package com.gonzalo.calculator.client;

import io.corp.calculator.TracerImpl;
import org.springframework.stereotype.Component;

@Component
public class TracerClient {

    private final TracerImpl client;

    public TracerClient() {
        client = new TracerImpl();
    }

    public <T> void trace(T result) {
        client.trace(result);
    }
}
