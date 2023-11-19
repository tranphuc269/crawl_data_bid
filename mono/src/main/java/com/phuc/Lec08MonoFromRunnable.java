package com.phuc;

import com.phuc.courseutil.Util;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {
    public static void main(String[] args) {
        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(Util.onNext(),
                        Util.onError(),
                        () -> {
                            System.out.println("Process Done");
                        });
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            Util.sleep(3);
            // kết quả này sẽ xong trước khi onComplete được thực thi
            System.out.println("Time consuming process Completed");
        };
    }
}
