package ru.savinov.dictionary.backend.patterns.observer.characters;

import ru.savinov.dictionary.backend.patterns.observer.weapon.WeaponBehavior;

public abstract class Character {
    WeaponBehavior weaponBehavior;

    public abstract void fight();

    public void setWeapon(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }
}
