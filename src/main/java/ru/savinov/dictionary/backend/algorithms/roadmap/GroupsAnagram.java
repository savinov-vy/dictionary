package ru.savinov.dictionary.backend.algorithms.roadmap;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupsAnagram {
    public static void main(String[] args) {
        List<List<String>> lists = groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupingByConsistenceWord = new HashMap<>();
        for (String str : strs) {
            String keyCode = stringToKey(str);
            if (groupingByConsistenceWord.containsKey(keyCode)) {
                groupingByConsistenceWord.get(keyCode).add(str);
            } else {
                List<String> listOfString = new ArrayList<>();
                listOfString.add(str);
                groupingByConsistenceWord.put(keyCode, listOfString);
            }
        }
        return new ArrayList<>(groupingByConsistenceWord.values());
    }

    public static String stringToKey(String word) {
        int[] keyCode = new int[26];
        for (Character ch : word.toCharArray()) {
            int numOfChar = ch - 'a';
            keyCode[numOfChar]++;
        }
        return Arrays.toString(keyCode);
    }
}
