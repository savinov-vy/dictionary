package ru.savinov.dictionary.streamAPI.IntegerNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MainClass {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));

        List<Integer> out = integerList.stream().filter(new Predicate<Integer>() {
            /**
             * filter ждет возврата Predicate (условия соотвествия данного объекта фильтру)
             * true - соответсвует
             * */
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        }).collect(Collectors.toList());
        System.out.println(out);

/**
 *forEach использует Consumer для обработки каждого элемента потока. Он может совершать
 * любое действие для каждого элемета проходящего через поток
 * */
        integerList.stream().filter(num -> num % 2 == 0).forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        });

        integerList.stream().filter(n -> n%2==0).forEach(n-> System.out.println(n));
    }
}
