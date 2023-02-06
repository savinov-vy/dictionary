package ru.savinov.dictionary.backend.patterns.strategy.weapon;

public class SwordBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("kick sword");
    }
}
