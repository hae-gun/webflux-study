package com.example.webflux.stepverifier;

import com.example.webflux.sequences.GeneralExample;
import org.junit.jupiter.api.*;
import reactor.test.StepVerifier;

public class StepVerifierExample02 {
    @Test
    public void sayHelloReactor(){
        StepVerifier
                .create(GeneralExample.sayHelloReactor())
                .expectSubscription()
                .expectNext("Hello")
                .expectNext("Reactor")
                .expectComplete()
                .verify();
    }
}
