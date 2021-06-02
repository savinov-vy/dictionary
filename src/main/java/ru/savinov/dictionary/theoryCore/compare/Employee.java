package ru.savinov.dictionary.theoryCore.compare;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Employee {

    static Integer countId = 1;
    int id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    public static Employee asOne(Integer id, String name, String surname, Integer salary) {
        return new Employee(id, name, surname, salary);
    }

    public static Employee asOneRandom() {
        return Employee.asOne(getId(), getRandomName(), getRandomSurname(), getRandomInteger());
    }

    public static List<Employee> asList(Integer count) {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(Employee.asOne(getId(), getRandomName(), getRandomSurname(), getRandomInteger()));
        }
        return list;
    }

    public static Integer getId() {
        Integer id = countId;
        countId++;
        return id;
    }

    public static String getRandomName() {
        List<String> nameList = Arrays.asList("Ivan", "Petya", "Tanya", "Masha", "Kolya", "Sasha", "Nastya");
        return getRandomString(nameList);
    }

    public static String getRandomSurname() {
        List<String> nameList = Arrays.asList("Ivanov", "Petrov", "Sidorov", "Tolstoy", "Savinov", "Ushakov", "Solzhenicin");
        return getRandomString(nameList);
    }


    public static String getRandomString(List <String> list) {
        Integer randomIndex = (int) (Math.random() * list.size());
        return list.get(randomIndex);
    }

    public static Integer getRandomInteger() {
        return (int) (Math.random() * 100000);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }
}


