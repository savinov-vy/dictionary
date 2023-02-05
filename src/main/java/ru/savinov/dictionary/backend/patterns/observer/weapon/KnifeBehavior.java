package ru.savinov.dictionary.backend.patterns.observer.weapon;

public class KnifeBehavior implements WeaponBehavior{
    @Override
    public void useWeapon() {
        System.out.println("kick knife");
    }
}
