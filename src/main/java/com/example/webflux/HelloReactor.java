package com.example.webflux;

import reactor.core.publisher.Flux;
import util.Logger;


public class HelloReactor {
    public static void main(String[] args) {
        Flux<String> sequence = Flux.just("Hello", "Reactor");

        sequence
                .map(data -> data.toLowerCase())
                .subscribe(data -> Logger.onNext(data));
    }
}
