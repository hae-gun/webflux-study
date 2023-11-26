package com.example.webflux.class02;

import reactor.core.publisher.Mono;
import util.Logger;

public class MonoExample {
    public static void main(String[] args) {
        Mono.empty()
                .subscribe(
                        data -> Logger.info("# emitted data {}", data),
                        error -> {},
                        () -> Logger.info("# emitted onComplete signal")
                );
    }
}
