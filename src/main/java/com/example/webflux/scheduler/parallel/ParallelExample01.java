package com.example.webflux.scheduler.parallel;

import reactor.core.publisher.Flux;
import util.Logger;

public class ParallelExample01 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[]{1,3,5,7,9,11,13,15})
                .parallel() // 병렬 처리 안됨.
                .subscribe(Logger::onNext);
    }

}
