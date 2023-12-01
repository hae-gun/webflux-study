package com.example.webflux.scheduler.parallel;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import util.Logger;
import util.TimeUtils;

public class ParallelExample02 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[]{1,3,5,7,9,11,13,15})
                .parallel()
                .runOn(Schedulers.parallel()) // ParallelFlux 에서 runOn method 를 통해 병렬 수행 parallel().runOn(스케쥴옵션)을 사용해야 병렬처리됨.
                .subscribe(Logger::onNext);
        TimeUtils.sleep(100L);
    }

}
