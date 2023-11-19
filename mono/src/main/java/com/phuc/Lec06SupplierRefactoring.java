package com.phuc;

import com.phuc.courseutil.Util;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


// Khi khởi tạo, supplier sẽ không block hoạt động của chương trình.
public class Lec06SupplierRefactoring {
    public static void main(String[] args) {
        getName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.onNext());
        getName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.onNext());
        getName()
                .subscribeOn(Schedulers.boundedElastic())
                .subscribe(Util.onNext());
        // có thể sử dụng cơ chế sleep để block luồng chính trong 4s, tại thời điểm này tất cả onNext đều success
        Util.sleep(4);
    }


    private static Mono<String> getName() {
        System.out.println("Get name method");

        return Mono.fromSupplier(() -> {
            System.out.println("Generating name...");
            Util.sleep(3);


            return Util.getFaker().name().fullName();
        }).map(String::toUpperCase);
    }

}
