package ru.savinov.dictionary.backend.algorithms;

import java.util.Arrays;

public class ConcatenationOfArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1};
        int[] concatenation = getConcatenation(arr);
        Arrays.stream(concatenation).forEach(System.out::println);
    }

    public static int[] getConcatenation(int[] nums) {
        int[] ints = new int[nums.length * 2];
        for (int i = 0; i < nums.length; i++) {
            ints[i] = nums[i];
        }

        for (int i = nums.length; i < ints.length; i++) {
            ints[i] = nums[i - nums.length];
        }
        return ints;
    }
}
