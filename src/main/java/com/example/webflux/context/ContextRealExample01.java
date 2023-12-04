package com.example.webflux.context;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.context.Context;
import util.Logger;
import util.TimeUtils;

/*
 * Context 활용예제
 * - 직교성을 가지는 정보를 표현할 때 자주 사용된다.
 * */
public class ContextRealExample01 {
    private static final String HEADER_NAME_AUTH_TOKEN = "authToken";

    public static void main(String[] args) {
        Mono<String> mono =
                postBook(Mono.just(
                        new Book("Reactor's Bible", "CHK"))
                )
                .contextWrite(Context.of(HEADER_NAME_AUTH_TOKEN, "eyJfkdlwHSdflwkenlasijlfWI"));

        mono.subscribe(Logger::onNext);

    }


    private static Mono<String> postBook(Mono<Book> book) {
        // zip Operator 를 이용하여 두 Mono 객체를 하나로 합침. 각 Mono 는 tuple 에 저장된다.
        return Mono.zip(book, Mono.deferContextual(ctx -> Mono.just(ctx.get(HEADER_NAME_AUTH_TOKEN))))
                .flatMap(tuple -> Mono.just(tuple)) // 외부 API로 요청했다고 가정.
                .flatMap(tuple -> {
                    String response = "POST the book(" + tuple.getT1().getBookName() +
                            "," + tuple.getT1().getAuthor() + ") with token: " +
                            tuple.getT2();
                    return Mono.just(response); // Http response 받았다고 가정.
                });
    }
}
