package ru.savinov.dictionary.backend.algorithms;

import java.util.Scanner;

public class FibonacciNumber {

    public static Integer ZERO_CELL = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long amount = getNumber(n);
        System.out.println(amount);
    }

    private static Long getNumber(Integer n) {
        if (n <= 1) {
            return Long.valueOf(n);
        }
        Long[] arr = new Long[n + ZERO_CELL];
        arr[0] = 0L;
        arr[1] = 1L;
        for (int i = 2; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2];
        }

        return arr[n];
    }
}
