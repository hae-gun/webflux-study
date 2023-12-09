package com.example.webflux.testpublisher;

import com.example.webflux.sequences.GeneralExample;
import org.junit.jupiter.api.*;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

public class TestPublisherTestExample04 {
    @Test
    void divideByTwoTest(){
        TestPublisher<Integer> source = TestPublisher.create();

        StepVerifier
                .create(source.flux().log())
                .expectSubscription()
                .then(() -> source.emit(1,2,3)) // next 는 onComplete() 시그널을 전송하지 않는다.
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectComplete()
                .verify();
    }
}
