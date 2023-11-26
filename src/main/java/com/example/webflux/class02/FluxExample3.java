package com.example.webflux.class02;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import util.Logger;

public class FluxExample3 {
    public static void main(String[] args) {
        Flux<Object> flux =
                Mono.justOrEmpty(null)
                        .concatWith(Mono.justOrEmpty("Jobs"));
        flux.subscribe(data -> Logger.info("# result : {}", data));
    }
}
