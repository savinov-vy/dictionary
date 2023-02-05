package ru.savinov.dictionary.backend.patterns.observer.characters;

import ru.savinov.dictionary.backend.patterns.observer.characters.Character;

public class Knight extends Character {

    @Override
    public void fight() {
        weaponBehavior.useWeapon();
    }
}
