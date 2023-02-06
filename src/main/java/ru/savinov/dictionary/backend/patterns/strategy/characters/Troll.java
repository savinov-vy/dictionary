package ru.savinov.dictionary.backend.patterns.strategy.characters;

public class Troll extends Character {
    @Override
    public void fight() {
        weaponBehavior.useWeapon();
    }
}
