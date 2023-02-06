package ru.savinov.dictionary.backend.patterns.strategy.characters;

public class Queen extends Character {
    @Override
    public void fight() {
        weaponBehavior.useWeapon();
    }
}
