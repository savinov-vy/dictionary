package ru.savinov.dictionary.backend.patterns.decorator.condiment_decorator;

import ru.savinov.dictionary.backend.patterns.decorator.beverage.Beverage;

public abstract class CondimentDecorator extends Beverage {
    @Override
    public abstract String getDescription();
}
