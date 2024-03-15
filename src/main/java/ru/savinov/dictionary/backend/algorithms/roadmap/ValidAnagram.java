package ru.savinov.dictionary.backend.algorithms.roadmap;

import java.util.HashMap;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("raacac", "caaaar"));
    }

    private static boolean isAnagram(String s, String t) {
        boolean result = true;
        if (s.length() != t.length()) {
            result = false;
        }
        HashMap<Character, Integer> countByChar = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (countByChar.containsKey(ch)) {
                Integer count = countByChar.get(ch);
                countByChar.put(ch, ++count);
            } else {
                countByChar.put(ch, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (countByChar.containsKey(ch)) {
                Integer count = countByChar.get(ch);
                countByChar.put(ch, --count);
                if (count == 0) {
                    countByChar.remove(ch);
                }
            } else {
                result = false;
            }
        }
        return result;
    }
}
