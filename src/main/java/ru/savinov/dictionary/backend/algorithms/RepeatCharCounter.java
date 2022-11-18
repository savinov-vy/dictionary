package ru.savinov.dictionary.backend.algorithms;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.util.Map;

/**
 * Найти какой символ в строке повторяется максимальное количество раз, приведено решение с помощью итератора по строке
 * но можно использовать str.toCharArray() -> foreach
 * итератор по строке не использует дополнительной памяти.
 */
public class RepeatCharCounter {

    public static void main(String[] args) {
        String str = "aacabbccc";
        String maxRepeatChar = findMaxRepeatChar(str);
        if (maxRepeatChar.isEmpty()) {
            System.out.println("String is empty");
        } else {
            System.out.println(maxRepeatChar);
        }

    }


    public static String findMaxRepeatChar(String str) {
        if (str.isEmpty()) {
            return "";
        }
        Map<Character, Integer> amountRepeatCh = countCharacter(str);
        return maxRepeat(amountRepeatCh);
    }

    private static Map<Character, Integer> countCharacter(String str) {
        StringCharacterIterator itr = new StringCharacterIterator(str);
        Map<Character, Integer> amountCh = new HashMap<>();

        while (itr.current() != CharacterIterator.DONE) {
            char currentCh = itr.current();
            Integer countCh = amountCh.get(currentCh);
            if (countCh == null) {
                amountCh.put(currentCh, 1);
            } else {
                amountCh.put(currentCh, ++countCh);
            }
            itr.next();
        }
        return amountCh;
    }

    private static String maxRepeat(Map<Character, Integer> amountRepeatCh) {
        Integer maxCount = 0;
        Character maxCh = null;
        for (Map.Entry<Character, Integer> entry : amountRepeatCh.entrySet()) {
            Integer value = entry.getValue();
            if (value > maxCount) {
                maxCh = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return maxCh + ": " + maxCount;
    }
}
