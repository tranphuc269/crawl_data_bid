package com.phuc.courseutil;

import com.github.javafaker.Faker;

import java.util.function.Consumer;

public class Util {

    private static final Faker faker = Faker.instance();

    public static Consumer<Object> onNext() {
        return o -> System.out.println("Receive : " + o);
    }

    public static Consumer<Throwable> onError() {
        return o -> System.out.println("Error : " + o.getMessage());
    }


    public static Runnable onComplete() {
        return () -> System.out.println("Complete");
    }


    public static Faker getFaker() {
        return faker;
    }


}
