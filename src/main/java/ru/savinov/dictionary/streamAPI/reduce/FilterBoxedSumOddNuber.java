package ru.savinov.dictionary.streamAPI.reduce;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.LongStream;

public class FilterBoxedSumOddNuber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String numberInterval = sc.nextLine();
        long [] interval = Arrays.stream(numberInterval.split(" ")).mapToLong(Long::parseLong).toArray();
        long a = interval[0];
        long b = interval[1];

        System.out.println(sumOfOddNumbersInRange(a,b));
    }

    public static long sumOfOddNumbersInRange(long start, long end) {
        return LongStream.rangeClosed(start,end)
                .filter(x -> x%2 != 0)
                .boxed()
                .reduce((acc, x) -> acc + x).orElse(0L);
    }

}
