package com.example.webflux.testpublisher;

import com.example.webflux.sequences.GeneralExample;
import org.junit.jupiter.api.*;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

public class TestPublisherTestExample03 {
    @Test
    void divideByTwoTest(){
        TestPublisher<Integer> source = TestPublisher.create();

        StepVerifier
                .create(GeneralExample.takeNumber(source.flux(), 3))
                .expectSubscription()
                .then(() -> source.emit(1,2,3,4,5))
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectComplete()
                .verify();
    }
}
