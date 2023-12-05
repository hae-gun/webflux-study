package com.example.webflux.debug.debugon;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;
import util.Logger;

public class DebugModExample02 {
    public static void main(String[] args) {
        Hooks.onOperatorDebug();

        Flux.just(2,4,6,8)
                .zipWith(Flux.just(1,2,3,0), (x, y) -> x/y)
                .subscribe(Logger::onNext, Logger::onError);
    }
}
