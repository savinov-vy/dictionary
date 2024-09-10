package ru.savinov.dictionary.backend.streamAPI.example;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MultiplicationTable {
    public static int[][] MULTIPLICATION_TABLE;

    public static void main(String[] args) {
        MULTIPLICATION_TABLE = new int[10][10];

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                MULTIPLICATION_TABLE[i][j] = (i + 1) * (j + 1);
            }
        }

        Arrays.stream(MULTIPLICATION_TABLE)
                .map(arr -> Arrays.stream(arr)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", ")))
                .forEach(System.out::println);

    }
}
