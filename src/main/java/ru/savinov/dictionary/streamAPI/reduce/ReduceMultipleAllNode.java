package ru.savinov.dictionary.streamAPI.reduce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReduceMultipleAllNode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long number = Long.parseLong(sc.nextLine());

        System.out.println(factorial(number));
    }

    public static long factorial(long n) {
        List<Long> list = new ArrayList<>();
        for (Long i = n; i > 0; i--) {
            list.add(i);
        }
        long answer = list.stream().reduce((acc, x) -> acc * x).get().longValue(); // при необходимости можно задать identity - начальное значение аккумулятора
        return answer;
    }

}