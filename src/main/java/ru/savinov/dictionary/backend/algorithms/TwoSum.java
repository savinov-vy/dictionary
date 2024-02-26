package ru.savinov.dictionary.backend.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        Arrays.stream(twoSum(new int[]{3,2,4}, 6)).forEach(System.out::println);
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexByNumber = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int secondNum = target - nums[i];

            if (indexByNumber.containsKey(secondNum)) {
                return new int[]{indexByNumber.get(secondNum), i};
            }
            indexByNumber.put(nums[i], i);
        }
        return new int[]{};
    }
}
