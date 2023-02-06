package ru.savinov.dictionary.backend.patterns.strategy.characters;

import ru.savinov.dictionary.backend.patterns.strategy.weapon.WeaponBehavior;

public abstract class Character {
    WeaponBehavior weaponBehavior;

    public abstract void fight();

    public void setWeapon(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }
}
