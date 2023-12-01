package com.example.webflux.scheduler;

import reactor.core.publisher.Flux;
import util.Logger;

public class SchedulerOperatorExample01 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[]{1,3,5,7})
                .filter(data -> data > 3)
                .map(data -> data * 10)
                .subscribe(Logger::onNext);
    }

}
