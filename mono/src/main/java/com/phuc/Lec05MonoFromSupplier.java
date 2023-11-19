package com.phuc;

import com.phuc.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec05MonoFromSupplier {
    public static void main(String[] args) {

        // use just only when you have data already
//        Mono<String> mono = Mono.just(getName());
        // fromSupplier is lazy init mono, getName had called if the function call subscribe
        Mono<String> mono = Mono.fromSupplier(Lec05MonoFromSupplier::getName);
        mono.subscribe(Util.onNext());
    }


    public static String getName() {
        System.out.println("Generating name ...");
        return Util.getFaker().name().fullName();
    }
}
