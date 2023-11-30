package com.example.webflux.sinks;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import util.Logger;


@Slf4j
public class SinksManyExample01 {
    public static void main(String[] args) throws InterruptedException {
        Sinks.Many<Integer> unicastSink = Sinks.many().unicast().onBackpressureBuffer(); // unicast -> 1개의 subscriber
        Flux<Integer> fluxView = unicastSink.asFlux();

        unicastSink.emitNext(1, Sinks.EmitFailureHandler.FAIL_FAST);
        unicastSink.emitNext(2, Sinks.EmitFailureHandler.FAIL_FAST);

        fluxView.subscribe(data -> Logger.onNext("Subscribe {}", data));

        unicastSink.emitNext(3, Sinks.EmitFailureHandler.FAIL_FAST);

        fluxView.subscribe(data -> Logger.onNext("Subscribe2 ", data));
    }
}

