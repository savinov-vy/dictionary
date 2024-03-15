package ru.savinov.dictionary.backend.theoryCore.init;

public class Animal {
    private int countPaws = 2;
    static String staticVar;

    static {
        staticVar = "static";
        System.out.println("\nstatic block Animal, static var: " + staticVar);
    }

    {
        System.out.println("non static block Animal");
    }

    public Animal() {
        System.out.println("конструктор Animal");
        countPaws = 4;
    }

    protected void voice() {
        System.out.println("voice of Animal");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "countPaws=" + countPaws +
                '}';
    }
}
