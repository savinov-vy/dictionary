package ru.savinov.dictionary.backend.concurrent;


import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateThread {
    volatile  int x = 0;


    public static void main(String[] args) {
        CreateThread c = new CreateThread();
        Runnable r = () -> {
            for (int i=0; i < 1000_000; i++) {
                c.x++;
            }
        };
        Stream.generate(() -> new Thread())
                .limit(10)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }
}
