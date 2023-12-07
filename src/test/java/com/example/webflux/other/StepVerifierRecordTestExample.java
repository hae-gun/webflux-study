package com.example.webflux.other;

import com.example.webflux.sequences.BackpressureExample;
import com.example.webflux.sequences.RecordExample;
import org.junit.jupiter.api.*;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class StepVerifierRecordTestExample {
    @Test
    public void generateNumberTest(){
        StepVerifier
                .create(RecordExample.getCountry(Flux.just("france", "russia", "greece", "poland")))
                .expectSubscription()
                .recordWith(ArrayList::new)
                .thenConsumeWhile(country -> !country.isEmpty())
                .consumeRecordedWith(contries -> {
                    assertThat(contries, everyItem(hasLength(6)));
                    assertThat(
                            contries.stream()
                                    .allMatch(country -> Character.isUpperCase(country.charAt(0))), is(true)
                    );
                })
                .expectComplete()
                .verify();
    }
}
