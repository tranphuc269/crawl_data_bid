package com.phuc;

import reactor.core.publisher.Flux;

public class Lec01FluxIntro {
    public static void main(String[] args) {
        Flux<Integer> flux = Flux.just(1, 2);
        flux.subscribe(Util.onNext());
    }
}
