package com.example.webflux.timetest;

import com.example.webflux.sequences.TimeBasedExample;
import org.junit.jupiter.api.*;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.scheduler.VirtualTimeScheduler;

import java.time.Duration;

public class StepVerifierTimeBasedExample01 {
    @Test
    public void sayHelloReactor(){
        StepVerifier
                .withVirtualTime(() -> TimeBasedExample.getCOVID19Count(
                        Flux.interval(Duration.ofHours(12)).take(1)
                    )
                ).expectSubscription()
                .then(() -> VirtualTimeScheduler.get().advanceTimeBy(Duration.ofHours(12))) // 파라미터 시간만큼 테스트 시간이 지났다치고 테스트 진행됨.
                .expectNextCount(11)
                .expectComplete()
                .verify();
    }
}
