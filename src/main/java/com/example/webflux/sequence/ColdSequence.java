package com.example.webflux.sequence;

import reactor.core.publisher.Flux;
import util.Logger;

import java.util.Arrays;

public class ColdSequence {
    public static void main(String[] args) {
        Flux<String> coldFlux = Flux.fromIterable(Arrays.asList("RED", "YELLOW", "BLUE"))
                .map(String::toLowerCase);

        coldFlux.subscribe(country -> Logger.info("# Subscriber1 : {}", country));
        Logger.info("------------------------------------");
        coldFlux.subscribe(country -> Logger.info("# Subscriber1 : {}", country));
    }
}
