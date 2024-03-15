package ru.savinov.dictionary.backend.theoryCore.init;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Cat(4);
        System.out.println(animal);
        animal.voice();
        System.out.println("\n=====================================\n");

        System.out.println("Второй раз static init block не отрабатывает");
        Animal cat = new Animal();
        System.out.println(cat);
        cat.voice();
    }
}
