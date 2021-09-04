package ru.savinov.dictionary.backend.streamAPI.reduce;

import java.util.Arrays;
import java.util.List;


public class Reduce {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1,2,3,4,5);
        /**
         * Задача reduce из набора объектов получить один объект по тем правилам которые будут указаны
         * принцип дейтвия: на место поля a будет поставлена переменная identity 0. На b ставится элемент стрима
         * 1 итеррация на место а кладется 0, на место b элемент из стрима 1 они складываются получается 1
         * 2 итеррация результат сложения 1 кладется на место а на место b кладется элемент стрима 2
         * 3 итеррация резултат сложения 3 кладется на место ф на место b кладется элемент стрима 3
         * 4 итеррация результат сложения 6..........
         */
        Integer reduce = intList.stream().reduce(0, (a, b) -> a + b);
        System.out.println(reduce);
    }
}
