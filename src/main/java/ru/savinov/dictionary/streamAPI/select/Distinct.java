package ru.savinov.dictionary.streamAPI.select;

import java.util.Arrays;

public class Distinct {
    public static void main(String[] args) {
        /**
         * Выбрать уникальные элементы
         */
        Arrays.asList(1,2,3,4,3,2,3,2,1).stream().distinct().forEach(System.out::println);
    }
}
