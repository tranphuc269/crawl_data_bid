package com.phuc;

import reactor.core.publisher.Mono;

public class Lec02Mono {
    public static void main(String[] args) {
        // publisher
        Mono<Integer> mono = Mono.just(1);
        mono.subscribe(i -> {
            System.out.println("Receive : " + i);
        });
    }
}
