package ru.savinov.dictionary.backend.algorithms.strings;

import java.util.HashMap;
import java.util.Map;

public class CounterChars {
    public static void main(String[] args) {
        String str = "anyString";
        char[] chars = str.toCharArray();
        System.out.println(chars);
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
