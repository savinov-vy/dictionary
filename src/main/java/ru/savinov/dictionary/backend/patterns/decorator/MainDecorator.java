package ru.savinov.dictionary.backend.patterns.decorator;

import ru.savinov.dictionary.backend.patterns.decorator.beverage.Beverage;
import ru.savinov.dictionary.backend.patterns.decorator.beverage.DarkRoast;
import ru.savinov.dictionary.backend.patterns.decorator.beverage.Espresso;
import ru.savinov.dictionary.backend.patterns.decorator.beverage.HouseBlend;
import ru.savinov.dictionary.backend.patterns.decorator.condiment_decorator.Mocha;
import ru.savinov.dictionary.backend.patterns.decorator.condiment_decorator.Soy;
import ru.savinov.dictionary.backend.patterns.decorator.condiment_decorator.Whip;

public class MainDecorator {
    public static void main(String[] args) {
        Beverage beverage = new Espresso();
        System.out.println(beverage.getDescription() + " $" + beverage.cost());

        Beverage beverage2 = new DarkRoast();
        beverage2 = new Mocha(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription() + " $" + beverage2.cost());

        Beverage beverage3 = new HouseBlend();
        beverage3 = new Soy(beverage3);
        beverage3 = new Mocha(beverage3);
        beverage3 = new Whip(beverage3);
        System.out.println(beverage3.getDescription() + " $" + beverage3.cost());
    }
}
