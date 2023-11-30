package com.example.webflux.sinks;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Sinks;
import util.Logger;


@Slf4j
public class SinksOneExample02 {
    public static void main(String[] args) throws InterruptedException {
        LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
        ch.qos.logback.classic.Logger rootLogger = loggerContext.getLogger(ch.qos.logback.classic.Logger.ROOT_LOGGER_NAME);
        rootLogger.setLevel(Level.DEBUG);

        Sinks.One<String> sinksOne = Sinks.one();
        Mono<String> mono = sinksOne.asMono();

        sinksOne.emitValue("Hello Reactor", Sinks.EmitFailureHandler.FAIL_FAST);

        sinksOne.emitValue("Hi Reactor", Sinks.EmitFailureHandler.FAIL_FAST);


        mono.subscribe(data -> Logger.onNext("Subscribe1 ", data));
        mono.subscribe(data -> Logger.onNext("Subscribe2 ", data));
    }
}

