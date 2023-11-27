package com.example.webflux.backpressure;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import util.Logger;
import util.TimeUtils;

import java.time.Duration;

public class BackpressureStrategyDropExample {
    public static void main(String[] args) {
        Flux
                .interval(Duration.ofMillis(1L))
                .onBackpressureDrop(dropped -> Logger.info("# dropped: {}", dropped))
                .doOnNext(Logger::onNext)
                .publishOn(Schedulers.parallel())
                .subscribe(data -> {
                    TimeUtils.sleep(5L);
                    Logger.info(data);
                }, error -> Logger.onError(error));

        TimeUtils.sleep(2000L);
    }
}
