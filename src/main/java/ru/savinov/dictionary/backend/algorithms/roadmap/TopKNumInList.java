package ru.savinov.dictionary.backend.algorithms.roadmap;

import java.util.Arrays;

import java.util.HashSet;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import static java.awt.Color.white;
import static java.awt.SystemColor.text;

public class TopKNumInList {

    public static int[] firstArray = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static int[] secondArray = new int[]{10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
    public static int[] resultArray;
    public static String[] strings;
    public static int[][] MULTIPLICATION_TABLE;

    public static void main(String[] args) {
        //напишите тут ваш код
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


    public static boolean isOnlyDigits(String text) {
        for (Character ch : text.toCharArray()) {
            if (!Character.isDigit(ch)) {
                return false;
            }
        }
        return true;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] freq = new int[nums.length];
        HashMap<Integer, Integer> numPosition = new HashMap<>();

        for (int n : nums) {

        }
//  переделать
        return null;
    }
}
