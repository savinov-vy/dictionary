package ru.savinov.dictionary.backend.theoryCore.init;

public class Cat extends Animal {
    private int countPaws;

    static {
        System.out.println("init static block cat");
    }

    {
        System.out.println("init block cat");
    }

    public Cat(int countPaws) {
        super();
        this.countPaws = countPaws;
        System.out.println("constructor cat - count paws cat: " + countPaws);
    }

    @Override
    protected void voice() {
        System.out.println("voice of Cat");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "countPaws=" + countPaws +
                '}';
    }
}
