package com.phuc.assignment;

import com.phuc.courseutil.Util;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
    private static final Path path = Paths.get("src/main/resources/assignment/mono");

    public static void main(String[] args) {
        FileService.read("file01.txt")
                .subscribe(Util.onNext());

        FileService.deleteFile("file04.txt");
    }

    public static Mono<String> read(String fileName) {
        return Mono.fromSupplier(() -> readFile(fileName));
    }

    public static Mono<Void> write(String fileName, String content) {
        return Mono.fromSupplier(() -> writeFile(fileName, content));
    }

    public static Mono<Void> delete(String fileName) {
        return Mono.fromSupplier(() -> deleteFile(fileName));
    }

    private static String readFile(String fileName) {
        try {
            return Files.readString(path.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Void writeFile(String fileName, String content) {
        try {
            Files.writeString(path.resolve(fileName), content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private static Void deleteFile(String fileName) {
        try {
            Files.delete(path.resolve(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


}
