package ru.savinov.dictionary.patterns;

public class Singleton {
    private static Singleton INSTANCE;

    private Singleton() { // конструктор приватный. Объект невозможно создать через метод new за пределами класса
    }

    public static Singleton getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}
