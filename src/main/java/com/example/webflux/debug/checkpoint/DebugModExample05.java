package com.example.webflux.debug.checkpoint;

import reactor.core.publisher.Flux;
import util.Logger;

public class DebugModExample05 {
    public static void main(String[] args) {
        Flux.just(2,4,6,8)
                .zipWith(Flux.just(1,2,3,0), (x, y) -> x/y)
                .checkpoint("CheckpointExample04.zipWith.checkpoint")
                .map(num -> num + 2)
                .checkpoint("CheckpointExample04.map.checkpoint")
                .subscribe(Logger::onNext, Logger::onError);
    }
}
