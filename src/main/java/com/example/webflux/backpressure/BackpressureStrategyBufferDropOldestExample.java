package com.example.webflux.backpressure;

import reactor.core.publisher.BufferOverflowStrategy;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import util.Logger;
import util.TimeUtils;

import java.time.Duration;

public class BackpressureStrategyBufferDropOldestExample {
    public static void main(String[] args) {
        Flux
                .interval(Duration.ofMillis(300L))
                .doOnNext(data -> Logger.info("# emitted by original Flux: {}", data))
                .onBackpressureBuffer(2,
                        dropped -> Logger.info("# Overflow & dropped: {}", dropped),
                        BufferOverflowStrategy.DROP_OLDEST)
                .doOnNext(data -> Logger.info("# emitted by Buffer {}", data))
                .publishOn(Schedulers.parallel(), false, 1)
                .subscribe(data -> {
                    TimeUtils.sleep(1000L);
                    Logger.onNext(data);
                }, error -> Logger.onError(error));
        TimeUtils.sleep(3000L);
    }
}
