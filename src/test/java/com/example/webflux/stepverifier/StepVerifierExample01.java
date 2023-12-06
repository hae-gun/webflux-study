package com.example.webflux.stepverifier;

import org.junit.jupiter.api.*;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class StepVerifierExample01 {
    @Test
    public void sayHelloReactor(){
        StepVerifier
                .create(Mono.just("Hello Reactor"))
                .expectNext("Hello Reactor")
                .expectComplete()
                .verify();
    }
}
