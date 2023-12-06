package com.example.webflux.stepverifier;

import com.example.webflux.hello.GeneralExample;
import org.junit.jupiter.api.*;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.StepVerifierOptions;

public class StepVerifierExample06 {
    @Test
    public void sayHelloReactor(){
        Flux<Integer> source = Flux.range(0, 1000);
        StepVerifier
                .create(GeneralExample.takeNumber(source, 500),
                        StepVerifierOptions.create().scenarioName("Verify from 0 to 499")) // 실패시 해당 이름으로 로그 출력됨.
                .expectSubscription()
                .expectNext(0)
                .expectNextCount(498) // expectNext 이후에 남은 emit을 숫자 만큼 진
                .expectNext(500)
                .expectComplete()
                .verify();
    }
}
