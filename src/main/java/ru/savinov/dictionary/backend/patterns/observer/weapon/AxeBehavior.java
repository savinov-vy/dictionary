package ru.savinov.dictionary.backend.patterns.observer.weapon;

public class AxeBehavior implements WeaponBehavior{
    @Override
    public void useWeapon() {
        System.out.println("axe kick");
    }
}
