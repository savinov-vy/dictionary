package ru.savinov.dictionary.backend.algorithms.roadmap;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(containsDuplicate(nums));
    }

    public static boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) {
            return false;
        }
        Set<Integer> bucket = new HashSet<>();
        bucket.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (bucket.contains(nums[i])) {
                return true;
            } else {
                bucket.add(nums[i]);
            }
        }
        return false;
    }
}
