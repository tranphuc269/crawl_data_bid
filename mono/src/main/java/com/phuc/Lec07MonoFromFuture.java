package com.phuc;

import com.phuc.courseutil.Util;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec07MonoFromFuture {
    public static void main(String[] args) {
        Mono.fromFuture(Lec07MonoFromFuture::getName)
                .subscribe(Util.onNext());

        Util.sleep(1);

    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> Util.getFaker().name().fullName());
    }

}
