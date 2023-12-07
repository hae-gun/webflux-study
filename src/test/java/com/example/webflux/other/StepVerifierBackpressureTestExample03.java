package com.example.webflux.other;

import com.example.webflux.sequences.BackpressureExample;
import org.junit.jupiter.api.*;
import reactor.test.StepVerifier;

public class StepVerifierBackpressureTestExample03 {
    @Test
    public void generateNumberTest(){
        StepVerifier
                .create(BackpressureExample.generateNumberByDropString(), 1L)
                .thenConsumeWhile(num -> num >= 1)
                .expectComplete()
                .verifyThenAssertThat() //  추가 검증
                .hasDiscardedElements()
                .hasDiscarded(2,3,4,5,6,98,99,100);
//                .hasDropped(2,3,4,5,6,98,99,100); // onNextDrop 에서 drop되는 데이터가 있는지 확인하는것. DROP 전략과는 다르다.
        // DROP 전략으로 drop 되는 데이터는 discarded 된다.
    }
}
