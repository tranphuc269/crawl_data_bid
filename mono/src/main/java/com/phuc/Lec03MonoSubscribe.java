package com.phuc;

import com.phuc.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {
    public static void main(String[] args) {
        Mono<Integer> mono = Mono.just("ball")
                .map(String::length)
                .map(l -> l * 3);
        mono.subscribe(Util.onNext(), Util.onError(), Util.onComplete());
    }
}
