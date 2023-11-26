package com.example.webflux.class02;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import util.Logger;

public class FluxExample1 {
    public static void main(String[] args) {
        Flux.just(3,6,9)
                .map(num -> Math.pow(num, 2))
                .subscribe(remainder -> Logger.info("# remainder {}", remainder));
    }
}
