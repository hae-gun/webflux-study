package com.example.webflux.sequence;

import reactor.core.publisher.Flux;
import util.Logger;
import util.TimeUtils;

import java.time.Duration;
import java.util.stream.Stream;

public class HotSequence {
    public static void main(String[] args) {
        Flux<String> concerFlux =
                Flux.fromStream(Stream.of("Singer A","Singer B","Singer C","Singer D"))
                        .delayElements(Duration.ofSeconds(1)).share();

        concerFlux.subscribe(singer -> Logger.info("# Subscriber1 is watching {}'s song", singer));

        TimeUtils.sleep(2500);

        concerFlux.subscribe(singer -> Logger.info("# Subscriber2 is watching {}'s song", singer));

        TimeUtils.sleep(2500);

    }
}
