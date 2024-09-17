package ru.savinov.dictionary.backend.streamAPI.example;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringToMapStreamApi {
    public static void main(String[] args) {
        var stringStream = Stream.of("JavaMustWin", "Override", "HelloWorld");

        getMap(stringStream).forEach((s, i) -> System.out.println(s + " - " + i));
    }

    public static Map<String, Integer> getMap(Stream<String> stringStream) {
        return stringStream
                .collect(Collectors.toMap(i->i, i -> i.length()));
    }
}
