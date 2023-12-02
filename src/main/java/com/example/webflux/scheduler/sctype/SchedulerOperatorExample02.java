package com.example.webflux.scheduler.sctype;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import util.Logger;
import util.TimeUtils;

public class SchedulerOperatorExample02 {
    public static void main(String[] args) {
        doTask("task1")
                .subscribe(Logger::onNext);
        doTask("task2")
                .subscribe(Logger::onNext);
        TimeUtils.sleep(200L);

    }

    private static Flux<Integer> doTask(String taskName){
        return Flux.fromArray(new Integer[]{1,3,5,7})
                .publishOn(Schedulers.single())
                .filter(data -> data > 3)
                .doOnNext(data -> Logger.doOnNext(taskName ,"filter", data))
                .map(data -> data * 10)
                .doOnNext(data -> Logger.doOnNext(taskName ,"map", data));
    }


}
