package ru.savinov.dictionary.backend.algorithms.strings;


import java.util.Arrays;

import static java.util.Objects.isNull;

public class FindTwoMaxNumber {
    public static void main(String[] args) {
        String nums = "-1 -9 -5 -3 -1 -2";
        if (isNull(nums) || nums.isEmpty()) {
            System.out.println("is empty string");
        } else {
            Integer[] ints = toArrayNum(nums);
            printTwoMaxNumber(ints);
        }
    }

    private static Integer[] toArrayNum(String nums) {
        String[] s = nums.split(" ");
        return Arrays.stream(s)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
    }

    private static void printTwoMaxNumber(Integer[] ints) {
        int max1 = Integer.max(ints[0], ints[1]);
        int max2 = Integer.min(ints[0], ints[1]);

        for (int i : ints) {
            if (max1 <= i) {
                max2 = max1;
                max1 = i;
            } else if (max2 < i) {
                max2 = i;
            }
        }
        System.out.println(max1 + " " + max2);
    }
}