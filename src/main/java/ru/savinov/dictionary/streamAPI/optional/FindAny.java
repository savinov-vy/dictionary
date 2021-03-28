package ru.savinov.dictionary.streamAPI.optional;

import ru.savinov.dictionary.streamAPI.buratinoFactory.BuratinoFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class FindAny {
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Optional<Integer> numOptional = intList.stream().filter(n -> n > 7).findAny();

        List<String> strList = new ArrayList<>(Arrays.asList("один", "два", "три"));
        Optional<String> strOptional = strList.stream().filter(n -> n.length() > 5).findAny();
        /**
         * ifPresent - Вернуть любой, если есть то выполнить метод. Если нет то ничего не будет
         */
        intList.stream().filter(n -> n>7).findAny().ifPresent(n -> System.out.println(n));

        /**
         * ifPresent - если объект есть то можно передать Consumer и выполнить с этим объектом какие либо действия
         */
        numOptional.ifPresent(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println("Прибавили строку" + integer);
            }
        });

        /**
         * orElse - если объект есть то вернется нужный объект если объекта нет то вернется дефолтный объект
         * того же типа или null
         */
        numOptional.orElse( null);
        strOptional.orElse("Ничего нет");
        /**
         * isPresent - если объект есть то вернет true
         */
        System.out.println(numOptional.isPresent());

    }
}
