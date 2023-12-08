package com.example.webflux.other;

import com.example.webflux.sequences.RecordExample;
import org.junit.jupiter.api.*;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;

public class StepVerifierRecordTestExample03 {
    @Test
    public void generateNumberTest(){
        StepVerifier
                .create(RecordExample.getCountry(Flux.just("france", "russia", "greece", "poland")))
                .expectSubscription()
                .recordWith(ArrayList::new)
                .thenConsumeWhile(country -> !country.isEmpty())
                .expectRecordedMatches(contries ->
                        contries.stream()
                                    .allMatch(country -> Character.isUpperCase(country.charAt(0))))
                .expectComplete()
                .verify();
    }
}
