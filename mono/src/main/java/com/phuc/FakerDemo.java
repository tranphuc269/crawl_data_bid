package com.phuc;

import com.github.javafaker.Faker;

public class FakerDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Faker faker = Faker.instance();
            System.out.println(faker.name().fullName());
        }
    }
}
