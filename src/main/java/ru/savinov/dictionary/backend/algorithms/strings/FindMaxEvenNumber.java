package ru.savinov.dictionary.backend.algorithms.strings;

/**
 * Найти максимальное чётное число (любые другие вариации требований к числу)
 * если отсутсвует вывести -1
 */
public class FindMaxEvenNumber {
    public static void main(String[] args) {
        int[] nums = {-8, -3, 0, -4, 5, 3, 2, 7, 8, 2};
        int result = findMaxEvenNumber(nums);
        System.out.println(result);
    }

    private static int findMaxEvenNumber(int[] nums) {
        int result = -1;
        for (int current : nums) {
            if (current % 2 == 0 && (result == -1 || result < current)) {
                result = current;
            }
        }
        return result;
    }
}
