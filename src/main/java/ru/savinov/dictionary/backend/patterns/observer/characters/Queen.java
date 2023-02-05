package ru.savinov.dictionary.backend.patterns.observer.characters;

public class Queen extends Character {
    @Override
    public void fight() {
        weaponBehavior.useWeapon();
    }
}
