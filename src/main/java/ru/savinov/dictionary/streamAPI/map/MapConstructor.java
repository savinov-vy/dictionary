package ru.savinov.dictionary.streamAPI.map;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapConstructor {
    public static void main(String[] args) {
        class User {
            String name;

            public User(String name) {
                this.name = name;
            }
        }
        Stream.of("Bob", "Bill", "Mary").map(n -> new User(n)).collect(Collectors.toList());
        Stream.of("Bob", "Bill", "Mary").map(User::new).collect(Collectors.toList());
    }

}
