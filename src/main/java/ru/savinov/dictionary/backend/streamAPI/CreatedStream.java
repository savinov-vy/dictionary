package ru.savinov.dictionary.backend.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreatedStream {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        /**
         * создать stream из List
         */
        integerList.stream().filter(n -> n%2==1).forEach(n-> System.out.println(n));

        /**
         * создать stream из значений
         */
        Stream.of("AA", "BBB", "C", "DDDD").forEach(n-> System.out.println(n));

        /**
         * создать stream из значений
         */
        Arrays.stream(new Integer[] {1,2,5}).findFirst();

    }
}
