package ru.savinov.dictionary.backend.algorithms.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CounterChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if (str.isEmpty()) {
            System.out.println("String is empty");
            return;
        }
        char[] chars = str.toCharArray();
        Map<Character, Integer> counterCh = new HashMap<>();
        Character maxRepeat = null;
        int amountRepeat = 0;
        for (Character ch : chars) {
            if (counterCh.containsKey(ch)) {
                Integer amount = counterCh.get(ch);
                int newAmount = amount + 1;
                counterCh.put(ch, newAmount);
                if (newAmount > amountRepeat) {
                    maxRepeat = ch;
                    amountRepeat = newAmount;
                }
            } else counterCh.put(ch, 1);
        }
            System.out.println(maxRepeat + " " + amountRepeat);
    }
}
