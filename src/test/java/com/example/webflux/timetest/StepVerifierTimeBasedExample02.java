package com.example.webflux.timetest;

import com.example.webflux.sequences.TimeBasedExample;
import org.junit.jupiter.api.*;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.time.Duration;

public class StepVerifierTimeBasedExample02 {
    @Test
    public void sayHelloReactor(){
        StepVerifier
                .withVirtualTime(() -> TimeBasedExample.getCOVID19Count(
                        Flux.interval(Duration.ofHours(12)).take(1)
                    )
                ).expectSubscription()
                .thenAwait(Duration.ofHours(12)) // 데이터 소스가 StepVerifier 에 12시간 당겨져서 실행됨.
                .expectNextCount(11)
                .expectComplete()
                .verify();
    }
}
