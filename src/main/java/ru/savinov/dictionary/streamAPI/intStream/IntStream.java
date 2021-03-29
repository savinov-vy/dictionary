package ru.savinov.dictionary.streamAPI.intStream;

import java.util.Arrays;
import java.util.List;

public class IntStream {

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(1,2,3,4,5);
        /**
         * обычный стрим интеов можно преобразовать в специальный поток для обработки чисел типа инт при помощи
         * mapToInt. Intstream обладает специальными методами для поиска среднего значения и т.п...
         */

        intList.stream().mapToInt(v -> v).sum();
    }

}
