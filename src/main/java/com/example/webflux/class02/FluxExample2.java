package com.example.webflux.class02;

import reactor.core.publisher.Flux;
import util.Logger;

public class FluxExample2 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[]{6, 7, 8})
                .filter(num -> num > 6)
                .map(num -> num * 2)
                .subscribe(multiply -> Logger.info("# multiply {}", multiply));
    }
}
