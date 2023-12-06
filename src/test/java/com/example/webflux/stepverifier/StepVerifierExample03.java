package com.example.webflux.stepverifier;

import com.example.webflux.hello.GeneralExample;
import org.junit.jupiter.api.*;
import reactor.test.StepVerifier;

public class StepVerifierExample03 {
    @Test
    public void sayHelloReactor(){
        StepVerifier
                .create(GeneralExample.sayHelloReactor())
                .expectSubscription()
                .as("# expect subscription")
                .expectNext("Hi")
                .as("# expect Hi") // 테스트 실패시 as 에서 작성한 description 출력됨.
                .expectNext("Reactor")
                .as("# expect Reactor")
                .verifyComplete();
    }
}
