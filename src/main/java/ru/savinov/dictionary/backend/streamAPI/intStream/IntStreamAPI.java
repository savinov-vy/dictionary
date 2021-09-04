package ru.savinov.dictionary.backend.streamAPI.intStream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Интстримы и подобные специфичные стримы служат для обработки специальными методами
 * такие как найти среднее значение, найти минимум, найти максимум и т.п.
 */
public class IntStreamAPI {

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        /**
         * обычный стрим интеов можно преобразовать в специальный поток для обработки чисел типа инт при помощи
         * mapToInt. Intstream обладает специальными методами для поиска среднего значения и т.п...
         * Преобразовать к потоку чисел можно объекты, но нужно описать правило по которому из объектов получатся
         * числа
         */
        int sum = intList.stream().mapToInt(v -> v).sum();

        /**
         * Среднее значение упаковать как Double
         */
        double asDouble = intList.stream().mapToInt(v -> v).average().getAsDouble();

        /**
         * Упаковать из Int Stream обратно в стрим интеджеров
         */
        List<Integer> collect = intList.stream().mapToInt(v -> v).boxed().collect(Collectors.toList());

        /**
        *rangeClosed создает стрим из элементов между двумя числами включительно 2 и 10
         */
        List<Integer> collect1 = IntStream.rangeClosed(2, 10).boxed().collect(Collectors.toList());
        System.out.println(collect1);
        /**
         *range создает стрим из элементов между двумя числами включительно 2 не включительно 10
         */
        List<Integer> collect2 = IntStream.range(2, 10).boxed().collect(Collectors.toList());
        System.out.println(collect2);
    }


}
