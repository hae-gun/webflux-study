package com.example.webflux.context;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import util.Logger;
import util.TimeUtils;

public class ContextIntroduceExample08 {
    public static void main(String[] args) {
        String key1 = "id";
        Mono.just("CHK")
//                        .transformDeferredContextual((stringMono, contextView) -> contextView.get("job"))
                .flatMap(name -> Mono.deferContextual(ctx -> //inner Sequence
                                Mono.just("! "+ctx.get(key1) + ", " + name)
                                        .transformDeferredContextual((mono, innerCtx) ->
                                                mono.map(data -> "# " + data + ", " + innerCtx.get("job"))
                                        ).contextWrite(context -> context.put("job", "Software Engineer"))
                        )
                )
                .publishOn(Schedulers.parallel())
                .contextWrite(context -> context.put(key1, "itVillage"))
                .subscribe(Logger::onNext);

        TimeUtils.sleep(100L);
    }
}
