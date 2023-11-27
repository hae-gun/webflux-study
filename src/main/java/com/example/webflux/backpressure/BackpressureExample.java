package com.example.webflux.backpressure;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import util.Logger;
import util.TimeUtils;

public class BackpressureExample {
    public static void main(String[] args) {
        Flux.range(1, 5)
                .doOnNext(Logger::doOnNext)
                .doOnRequest(Logger::doOnRequest)
                .subscribe(new BaseSubscriber<Integer>() {
                    @Override
                    protected void hookOnSubscribe(Subscription subscription) {
                        request(1);
                    }

                    @Override
                    protected void hookOnNext(Integer value) {
                        TimeUtils.sleep(2000L);
                        Logger.onNext(value);
                        request(1);
                    }
                });
    }
}
