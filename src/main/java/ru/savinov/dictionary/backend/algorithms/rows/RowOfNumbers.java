package ru.savinov.dictionary.backend.algorithms.rows;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RowOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstLine = sc.nextLine();
        int n = Integer.parseInt(firstLine);
        String[] answer = splitToAddendum(n);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }

    public static String[] splitToAddendum(int n) {
        if (n == 0) {
            return new String[]{"0", "0"};
        }
        int count = 1;
        int sum = count;
        List<Integer> rowOfNum = new LinkedList<>();
        while (sum <= n) {
            rowOfNum.add(count);
            if ((n - sum) <= count) {
                int tail = count + (n - sum);
                rowOfNum.remove(rowOfNum.size() - 1);
                rowOfNum.add(tail);
                break;
            }
            count++;
            sum += count;
        }

        String[] answer = new String[2];
        answer[0] = rowOfNum.size() + "";
        StringBuilder result = new StringBuilder();
        rowOfNum.forEach(num -> result.append(num).append(" "));
        answer[1] = new String(result);
        return answer;
    }
}
