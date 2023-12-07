package com.example.webflux.timetest;

import com.example.webflux.sequences.TimeBasedExample;
import org.junit.jupiter.api.*;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.util.function.Tuples;

import java.time.Duration;

public class StepVerifierTimeBasedExample04 {
    @Test
    public void sayHelloReactor(){
        StepVerifier
                .withVirtualTime(() -> TimeBasedExample.getVoteCount(
                        Flux.interval(Duration.ofMinutes(1))
                    )
                ).expectSubscription()
                .expectNoEvent(Duration.ofMinutes(1))
                .expectNext(Tuples.of("중구", 15400))
                .expectNoEvent(Duration.ofMinutes(1))
                .expectNoEvent(Duration.ofMinutes(1))
                .expectNoEvent(Duration.ofMinutes(1))
                .expectNoEvent(Duration.ofMinutes(1))
                .expectNextCount(4)
                .expectComplete()
                .verify(Duration.ofSeconds(3));
    }
}
