package ru.savinov.dictionary.backend.streamAPI.forEach;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ForEachSOUTeachNode {
    public static void main(String[] args) {
        Set<String> nameSet = new TreeSet<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));
        nameSet.stream().forEach(System.out::println);
    }
}
