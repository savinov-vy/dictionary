package ru.savinov.stepik;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count;
        count = sc.nextInt();
      //  (−15,12]∪(14,17)∪[19,+∞)
        if (count>-15&&count<=12) {
            System.out.println(true);
        } else if (count > 14 && count < 17) {
            System.out.println(true);
        } else if (count >= 19) {
            System.out.println(true);
        } else System.out.println(false);
    }
}