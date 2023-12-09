package com.example.webflux.testpublisher;

import com.example.webflux.sequences.GeneralExample;
import org.junit.jupiter.api.*;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

public class TestPublisherTestExample05 {
    @Test
    void divideByTwoTest(){
//        TestPublisher<Integer> source = TestPublisher.createNoncompliant(TestPublisher.Violation.ALLOW_NULL);
        TestPublisher<Integer> source = TestPublisher.create();

        StepVerifier
                .create(GeneralExample.divideByTwo(source.flux()))
                .expectSubscription()
                .then(() -> source.emit(2,4,6,8,null)) // next 는 onComplete() 시그널을 전송하지 않는다.
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .expectComplete()
                .verify();
    }
}
