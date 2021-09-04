package ru.savinov.dictionary.backend.streamAPI.select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Math {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        /**
         * Проверить все ли элементы коллекции соответствуют условию
         * Любой элемент коллекциисоответствует условию
         * Не один элемент коллекции не соответствует условию
         */
        System.out.println(intList.stream().allMatch(n -> n<10));
        System.out.println(intList.stream().anyMatch(n -> n==4));
        System.out.println(intList.stream().noneMatch(n -> n==2));
    }
}
