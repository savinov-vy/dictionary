package ru.savinov.dictionary.backend.streamAPI.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToList {
    public static void main(String[] args) {
        var numbers = Stream.of(-1, 10, 43, 0, -32, -4, 22);

        getPositiveNumbers(numbers).forEach(System.out::println);
    }

    /**collect to positive integers list*/
    public static List<Integer> getPositiveNumbers(Stream<Integer> numbers) {
        return numbers
                .filter(i -> i > 0)
                .collect(Collectors.toList());
    }
}
