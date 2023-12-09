package com.example.webflux.testpublisher;

import com.example.webflux.sequences.GeneralExample;
import org.junit.jupiter.api.*;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

public class TestPublisherTestExample01 {
    @Test
    void divideByTwoTest(){
        TestPublisher<Integer> source = TestPublisher.create();

        StepVerifier
                .create(GeneralExample.divideByTwo(source.flux()))
                .expectSubscription()
                .then(() -> source.next(2,4,6,8,10))
                .expectNext(1,2,3,4,5)
                .expectComplete()
                .verify();
    }
}
