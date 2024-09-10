package ru.savinov.dictionary.backend.algorithms;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BuildArrayFromPermutation {
    public static void main(String[] args) {
        int n = 10000;

        String collect = IntStream.range(0, n)
//                .map(i -> {
//                    int a = (int) (Math.random() * 10);
//                    int b = (int) (Math.random() * 120);
//                    if (a % 2 == 0) {
//                        return b * -1;
//                    } else {
//                        return b;
//                    }
//                })
                .limit(10000)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(collect);
    }
}
