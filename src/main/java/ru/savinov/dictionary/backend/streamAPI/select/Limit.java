package ru.savinov.dictionary.backend.streamAPI.select;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Limit {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);

        /**
         * отфильтровать, возвести в квадрат, оставить 2 первых элемента
         */
        List<Integer> out = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .limit(2)
                .collect(Collectors.toList());

        System.out.println(numbers);
        System.out.println(out);
    }
}
