package com.example.webflux.class02;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import util.Logger;

public class FluxExample4 {
    public static void main(String[] args) {
        Flux.concat(
                Flux.just("Venus"),
                Flux.just("Earth"),
                Flux.just("Mars"))
            .collectList()
            .subscribe(planetList -> Logger.info("# Solar System : {}", planetList));
    }
}
