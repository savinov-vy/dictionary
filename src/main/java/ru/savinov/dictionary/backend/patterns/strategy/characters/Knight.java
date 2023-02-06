package ru.savinov.dictionary.backend.patterns.strategy.characters;


public class Knight extends Character {
    @Override
    public void fight() {
        weaponBehavior.useWeapon();
    }
}
