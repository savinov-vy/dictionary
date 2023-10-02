package ru.savinov.dictionary.backend.algorithms;

import java.util.Scanner;

public class FibonacciLastNumber {

    public static Integer ZERO_NUMBER_FIBONACCI = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer amount = getNumber(n);
        System.out.println(amount);
    }

    private static Integer getNumber(Integer n) {
        if (n <= 1) {
            return Integer.valueOf(n);
        }
        n = n + ZERO_NUMBER_FIBONACCI;
        Integer[] arr = new Integer[2];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i < n; i++) {
            int sum = arr[0] + arr[1];
            arr[0] = arr[1];
            arr[1] = sum;
            if (arr[1] > 9) {
                arr[1] = arr[1]%10;
            }
        }
        return arr[1];
    }
}
