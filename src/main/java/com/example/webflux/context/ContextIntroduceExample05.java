package com.example.webflux.context;

import org.springframework.scheduling.config.SchedulerBeanDefinitionParser;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.context.Context;
import util.Logger;
import util.TimeUtils;

public class ContextIntroduceExample05 {
    public static void main(String[] args) {
        String key = "id";

        Mono<String> mono = Mono.deferContextual(ctx ->
                Mono.just("ID: " + ctx.get(key))
        ).publishOn(Schedulers.parallel());

        mono.contextWrite(context -> context.put(key, "itVillage"))
                .subscribe(data -> Logger.onNext("subscribe 1 ", data));

        mono.contextWrite(context -> context.put(key, "itWorld"))
                .subscribe(data -> Logger.onNext("subscribe 2 ", data));
        TimeUtils.sleep(100L);
    }
}
