package ru.savinov.dictionary.backend.patterns.decorator.beverage;

public class Decaf extends Beverage {

    public Decaf() {
        description = "Decaf";
    }

    @Override
    public double cost() {
        return 1.2;
    }
}
