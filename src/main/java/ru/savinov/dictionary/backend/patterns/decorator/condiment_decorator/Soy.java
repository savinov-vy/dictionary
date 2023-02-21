package ru.savinov.dictionary.backend.patterns.decorator.condiment_decorator;

import ru.savinov.dictionary.backend.patterns.decorator.beverage.Beverage;

public class Soy extends CondimentDecorator {
    Beverage beverage;

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return 0.3 + beverage.cost();
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
}
