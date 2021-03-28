package ru.savinov.dictionary.streamAPI.employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeClass {

    static class Person {

        enum Position {
            ENGINEER, MANAGER, DIRECTOR
        }

        private String name;
        private Integer age;
        private Position position;

        public Person(String name, Integer age, Position position) {
            this.name = name;
            this.age = age;
            this.position = position;
        }

        public static void main(String[] args) {
            List<Person> persons = new ArrayList<>(Arrays.asList(
                    new Person("Bob1", 35, Position.MANAGER),
                    new Person("Bob2", 44, Position.DIRECTOR),
                    new Person("Bob3", 25, Position.ENGINEER),
                    new Person("Bob4", 42, Position.ENGINEER),
                    new Person("Bob5", 55, Position.MANAGER),
                    new Person("Bob6", 19, Position.MANAGER),
                    new Person("Bob7", 33, Position.ENGINEER),
                    new Person("Bob8", 37, Position.MANAGER)
            ));

            /**
             * задача выделить инженеров отсортировать по возврасту распечатать имена
             */
            List<String> names = persons.stream()
                    //фильтруем
                    .filter(person -> person.position.equals(Position.ENGINEER))
                    //сортируем в порядке уменьшения возраста
                    .sorted(((o1, o2) -> o2.age - o1.age))
                    //Function <Person, String> преобразовываем сотрудников к строке далее обозначаем каким образом
                    .map((Function<Person, String>) person -> person.name)
                    //запихиваем в список
                    .collect(Collectors.toList());
            System.out.println("\n*******************  task1  ************************\n");
            System.out.println(names);
            System.out.println("\n****************************************************\n");
        }
    }

}
