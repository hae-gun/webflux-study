package com.example.webflux.sinks;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import util.Logger;

import java.util.stream.IntStream;

import static reactor.core.publisher.Sinks.EmitFailureHandler.FAIL_FAST;

@Slf4j
public class SinksOneExample01 {
    public static void main(String[] args) throws InterruptedException {
        Sinks.One<String> sinksOne = Sinks.one();
        Mono<String> mono = sinksOne.asMono();

        sinksOne.emitValue("Hello Reactor", FAIL_FAST);

        mono.subscribe(data -> Logger.onNext("Subscribe1 ", data));
        mono.subscribe(data -> Logger.onNext("Subscribe2 ", data));
    }
}

