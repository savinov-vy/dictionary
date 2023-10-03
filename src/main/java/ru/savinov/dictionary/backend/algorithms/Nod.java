package ru.savinov.dictionary.backend.algorithms;

import java.util.Scanner;

public class Nod {
    private static Long nod;
    private static Long remainder;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        System.out.println(maxDivider(a, b));
    }

    private static long maxDivider(long a, long b) {
        if (a == 0) {
            nod = b;
        } else if (b == 0 || a == b) {
            nod = a;
        } else if (a > b) {
            remainder = a % b;
            maxDivider(remainder, b);
        } else {
            remainder = b % a;
            maxDivider(a, remainder);
        }
        return nod;
    }

}
