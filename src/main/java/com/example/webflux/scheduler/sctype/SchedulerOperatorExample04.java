package com.example.webflux.scheduler.sctype;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import util.Logger;
import util.TimeUtils;

public class SchedulerOperatorExample04 {
    public static void main(String[] args) {
        Mono<Integer> flux
                = Mono.just(1)
                .publishOn(Schedulers.newParallel("Parallel Thread", 4, true));

        Logger.info("# start");

        flux.subscribe(data -> {
            TimeUtils.sleep(5000L);
            Logger.onNext("subscribe 1 done", data);
        });

        flux.subscribe(data -> {
            TimeUtils.sleep(4000L);
            Logger.onNext("subscribe 2 done", data);
        });

        flux.subscribe(data -> {
            TimeUtils.sleep(3000L);
            Logger.onNext("subscribe 3 doing", data);
        });
        flux.subscribe(data -> {
            TimeUtils.sleep(2000L);
            Logger.onNext("subscribe 4 doing", data);
        });

        TimeUtils.sleep(6000L);
    }
}
