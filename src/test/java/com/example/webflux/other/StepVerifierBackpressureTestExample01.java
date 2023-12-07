package com.example.webflux.other;

import com.example.webflux.sequences.BackpressureExample;
import org.junit.jupiter.api.*;
import reactor.test.StepVerifier;

public class StepVerifierBackpressureTestExample01 {
    @Test
    public void generateNumberTest(){
        StepVerifier
                .create(BackpressureExample.generateNumberByErrorString(), 1L)
                .thenConsumeWhile(num -> num>=1)
                .verifyComplete();
    }
}
