package ru.savinov.dictionary.backend.algorithms.roadmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SumTwoNumbers {
    public static void main(String[] args) {
        int[] nums = {3,3};
        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> bucket = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (bucket.containsKey(target - nums[i])) {
                result[0] = bucket.get(target - nums[i]);
                result[1] = i;
                return result;
            } else {
                bucket.put(nums[i], i);
            }
        }
        return result;
    }
}
