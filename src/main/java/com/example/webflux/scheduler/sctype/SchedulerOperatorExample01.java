package com.example.webflux.scheduler.sctype;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import util.Logger;

public class SchedulerOperatorExample01 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[]{1,3,5,7})
                .doOnNext(data -> Logger.doOnNext("fromArray", data))
                .publishOn(Schedulers.parallel())
                .filter(data -> data > 3)
                .doOnNext(data -> Logger.doOnNext("filter", data))
                .publishOn(Schedulers.immediate())
                .map(data -> data * 10)
                .doOnNext(data -> Logger.doOnNext("map", data))
                .subscribe(Logger::onNext);
    }
}
