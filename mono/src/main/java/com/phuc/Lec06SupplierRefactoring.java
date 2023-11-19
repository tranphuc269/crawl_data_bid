package com.phuc;

import com.phuc.courseutil.Util;
import reactor.core.publisher.Mono;


// Khi khởi tạo, supplier sẽ không block hoạt động của chương trình.
public class Lec06SupplierRefactoring {
    public static void main(String[] args) {
        getName();
        getName().subscribe(Util.onNext());
        getName();
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
