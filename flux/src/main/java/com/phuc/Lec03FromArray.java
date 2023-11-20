package com.phuc;

import reactor.core.publisher.Flux;

import java.util.List;

public class Lec03FromArray {
    public static void main(String[] args) {
        List<String> list = List.of("a", "b", "c", "d");

        Flux.fromIterable(list)
                .subscribe(Util.onNext());

    }

}
