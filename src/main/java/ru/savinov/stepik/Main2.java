package ru.savinov.stepik;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i > 0; i--) {
            int n = sc.nextInt();
            list.add(n);
        }
        System.out.println((list.get(1) - (list.get(1) % list.get(0)))/list.get(0));
    }
}
