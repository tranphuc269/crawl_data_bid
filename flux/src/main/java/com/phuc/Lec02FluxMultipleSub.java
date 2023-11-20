package com.phuc;

import reactor.core.publisher.Flux;

public class Lec02FluxMultipleSub {
    public static void main(String[] args) {
        Flux<Integer> integerFlux = Flux.just(1, 2, 3, 4);

        integerFlux.subscribe(Util.onNext());
        integerFlux.subscribe((value)-> {
            System.out.println("SUB 2 :: " + value);
        });
    }
}
