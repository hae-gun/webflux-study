package com.example.webflux.scheduler.parallel;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import util.Logger;
import util.TimeUtils;

public class ParallelExample04 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[]{1,3,5,7,9,11,13,15,17,19})
                .parallel(4) // parallel 안에 인자값을 넣어 Thread 갯수 제한. CPU 논리코어 갯수범위 안에서 숫자만큼 스레드 사용
                .runOn(Schedulers.parallel())
                .subscribe(Logger::onNext);
        TimeUtils.sleep(100L);
    }

}
