package com.example.webflux.stepverifier;

import com.example.webflux.sequences.GeneralExample;
import org.junit.jupiter.api.*;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class StepVerifierExample05 {
    @Test
    public void sayHelloReactor(){
        Flux<Integer> source = Flux.just(2,4,6,8,10);
        StepVerifier
                .create(GeneralExample.divideByTwo(source))
                .expectSubscription()
                .expectNext(1,2,3,4,5)
                .expectComplete()
                .verify();
    }
}
