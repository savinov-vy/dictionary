package ru.savinov.dictionary.backend.streamAPI.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MapForEach {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<String> strList = new ArrayList<>(Arrays.asList("AA", "BBB", "C", "DDDD"));

        /**
         * Из набора строк получить набор чисел
         */
        strList.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        }).forEach(System.out::println);
        // идентично
        strList.stream().map(s -> s.length()).forEach(System.out::println);

        /**
         * Из набора строк получить набор чисел * 10
         */
        intList.stream().map(new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer * 10;
            }
        }).forEach(System.out::println);


        intList.stream().map(i -> i * 10).forEach(System.out::println);
        //идентично
        intList.stream().map(i -> i * 10).forEach(n -> System.out.println(n));
        /**
         * У каждого объекта типа стринг вызвать метод length и преобразовать
         * :: запись обозначает что у каждого объекта в потоке этого типа вызвать метод
         */

        strList.stream().map(String::length).forEach(System.out::println);
        //идентично
        strList.stream().map(s -> s.length()).forEach(System.out::println);

    }


}
