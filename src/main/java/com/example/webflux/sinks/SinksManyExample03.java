package com.example.webflux.sinks;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import util.Logger;


@Slf4j
public class SinksManyExample03 {
    public static void main(String[] args) throws InterruptedException {
        // 구독 이후, emit 된 데이터 중에서 최신 데이터 2개만 replay 된다.
        Sinks.Many<Integer> replaySink = Sinks.many().replay().limit(2);
        Flux<Integer> fluxView = replaySink.asFlux();

        replaySink.emitNext(1, Sinks.EmitFailureHandler.FAIL_FAST);
        replaySink.emitNext(2, Sinks.EmitFailureHandler.FAIL_FAST);
        replaySink.emitNext(3, Sinks.EmitFailureHandler.FAIL_FAST);

        fluxView.subscribe(data -> Logger.onNext("Subscribe1 ", data));
        fluxView.subscribe(data -> Logger.onNext("Subscribe2 ", data));


    }
}

