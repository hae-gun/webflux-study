package com.example.webflux.timetest;

import com.example.webflux.sequences.TimeBasedExample;
import org.junit.jupiter.api.*;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class StepVerifierTimeBasedExample03 {
    @Test
    public void sayHelloReactor(){
        StepVerifier
                .withVirtualTime(() -> TimeBasedExample.getCOVID19Count(
                        Flux.interval(Duration.ofMinutes(1)).take(1)
                    )
                ).expectSubscription()
                .expectNextCount(11)
                .expectComplete()
                .verify(Duration.ofSeconds(3));
    }
}
