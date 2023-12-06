package com.example.webflux.stepverifier;

import com.example.webflux.hello.GeneralExample;
import org.junit.jupiter.api.*;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class StepVerifierExample04 {
    @Test
    public void sayHelloReactor(){
        Flux<Integer> source = Flux.just(2,4,6,8,10);
        StepVerifier
                .create(GeneralExample.occurError(source))
                .expectSubscription()
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .expectError()
                .verify();
    }
}
