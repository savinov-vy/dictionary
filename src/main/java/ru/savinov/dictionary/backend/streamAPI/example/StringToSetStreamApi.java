package ru.savinov.dictionary.backend.streamAPI.example;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringToSetStreamApi {

    public static void main(String[] args) {
        var stringStream = Stream.of("JavaMustWin", "CodeGym", "To", "Controller", "Huck");

        getFilteredStrings(stringStream).forEach(System.out::println);
    }

    /** to Set if length > 6 characters */
    public static Set<String> getFilteredStrings(Stream<String> stringStream) {
        return stringStream
                .filter(s -> s.length() > 6)
                .collect(Collectors.toSet());
    }
}
