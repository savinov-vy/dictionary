package ru.savinov.dictionary.backend.algorithms.strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import java.util.stream.Collectors;

/**
 * найти слова наименьшей длины. Вывести их разделённые запятой
 */
public class FindWordMinLength {
    public static void main(String[] args) {
        String[] words = {"w", null, "o", "te", "asdf", "asdfs", "r", "asdf", "d", "sdfw"};
        printMinLengthWords(words);
    }

    private static void printMinLengthWords(String[] words) {
        OptionalInt minLength = Arrays.stream(words)
                .filter(Objects::nonNull)
                .mapToInt(String::length)
                .min();

        String result = Arrays.stream(words)
                .filter(Objects::nonNull)
                .filter(word -> word.length() == minLength.getAsInt())
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
