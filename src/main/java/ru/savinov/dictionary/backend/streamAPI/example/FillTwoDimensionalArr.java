package ru.savinov.dictionary.backend.streamAPI.example;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FillTwoDimensionalArr {

    public static int[][] result = new int[10][];

    public static void main(String[] args) {
        //напишите тут ваш код
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < result; j++) {
//            }
//        }
    }

    private void fillTwoDimensionalArr() {
        IntStream.range(0, result.length)
                .boxed()
                .collect(Collectors.toMap(i -> i, i -> result[i]));

    }

}
