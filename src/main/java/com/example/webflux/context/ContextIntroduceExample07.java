package com.example.webflux.context;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import util.Logger;
import util.TimeUtils;

public class ContextIntroduceExample07 {
    public static void main(String[] args) {
        String key1 = "id";

        Mono.deferContextual(ctx ->
                        Mono.just("ID: " + ctx.get(key1))
                ).publishOn(Schedulers.parallel())
                .contextWrite(context -> context.put(key1, "itWorld"))
                .contextWrite(context -> context.put(key1, "itVillage"))
                .subscribe(Logger::onNext);

        TimeUtils.sleep(100L);
    }
}
