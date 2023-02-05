package ru.savinov.dictionary.backend.patterns.observer.weapon;

public class SwordBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("kick sword");
    }
}
