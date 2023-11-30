package com.example.webflux.sinks;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import util.Logger;


@Slf4j
public class SinksManyExample02 {
    public static void main(String[] args) throws InterruptedException {
        Sinks.Many<Integer> multicast = Sinks.many().multicast().onBackpressureBuffer(); // unicast -> 1개의 subscriber
        Flux<Integer> fluxView = multicast.asFlux();

        multicast.emitNext(1, Sinks.EmitFailureHandler.FAIL_FAST);
        multicast.emitNext(2, Sinks.EmitFailureHandler.FAIL_FAST);

        fluxView.subscribe(data -> Logger.onNext("Subscribe1 ", data));
        fluxView.subscribe(data -> Logger.onNext("Subscribe2 ", data));

        multicast.emitNext(3, Sinks.EmitFailureHandler.FAIL_FAST);

    }
}

