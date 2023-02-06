package ru.savinov.dictionary.backend.patterns.strategy.weapon;

public class AxeBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("axe kick");
    }
}
