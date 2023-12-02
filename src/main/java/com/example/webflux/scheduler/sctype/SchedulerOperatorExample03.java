package com.example.webflux.scheduler.sctype;

import ch.qos.logback.core.util.TimeUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import util.Logger;
import util.TimeUtils;

public class SchedulerOperatorExample03 {
    public static void main(String[] args) {
        Scheduler scheduler = Schedulers.newBoundedElastic(2, 2, "I/O-Thread");

        Mono<Integer> mono =
                Mono.just(1)
                        .subscribeOn(scheduler);

        Logger.info("# start");

        mono.subscribe(data -> {
            Logger.onNext("subscribe 1 doing", data);
            TimeUtils.sleep(3000L);
            Logger.onNext("subscribe 1 done", data);
        });

        mono.subscribe(data -> {
            Logger.onNext("subscribe 2 doing", data);
            TimeUtils.sleep(3000L);
            Logger.onNext("subscribe 2 done", data);
        });

        mono.subscribe(data -> {
            Logger.onNext("subscribe 3 doing", data);
        });
        mono.subscribe(data -> {
            Logger.onNext("subscribe 4 doing", data);
        });
        mono.subscribe(data -> {
            Logger.onNext("subscribe 5 doing", data);
        });
        mono.subscribe(data -> {
            Logger.onNext("subscribe 6 doing", data);
        });

        TimeUtils.sleep(4000L);
        scheduler.dispose();
    }
}
