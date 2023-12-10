package com.example.webflux.publisherprobe;

import com.example.webflux.sequences.PublisherProbeExample;
import org.junit.jupiter.api.*;
import reactor.test.StepVerifier;
import reactor.test.publisher.PublisherProbe;

public class PublisherProbeTestExample01 {
    @Test
    void publisherProbeTest(){
        PublisherProbe<String> probe = PublisherProbe.of(PublisherProbeExample.useStandbyPower());

        StepVerifier
                .create(PublisherProbeExample.processWith(PublisherProbeExample.useMainPower(), probe.mono()))
                .expectNextCount(1)
                .verifyComplete();

        probe.assertWasSubscribed();
        probe.assertWasRequested();
        probe. assertWasNotCancelled();
    }
}
