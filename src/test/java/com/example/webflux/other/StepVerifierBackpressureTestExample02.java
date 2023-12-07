package com.example.webflux.other;

import com.example.webflux.sequences.BackpressureExample;
import org.junit.jupiter.api.*;
import reactor.test.StepVerifier;

public class StepVerifierBackpressureTestExample02 {
    @Test
    public void generateNumberTest(){
        StepVerifier
                .create(BackpressureExample.generateNumberByErrorString(), 1L)
                .thenConsumeWhile(num -> num >= 1)
                .expectError()
                .verifyThenAssertThat()
                .hasDiscardedElements()
                .hasDiscarded(2)
                .hasDroppedElements()
                .hasDropped(3,4,5,6,98,99,100);
    }
}
