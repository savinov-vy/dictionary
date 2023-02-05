package ru.savinov.dictionary.backend.patterns.observer.weapon;

public class BowAndArrowBehavior implements WeaponBehavior {
    @Override
    public void useWeapon() {
        System.out.println("Bow and arrow kick");
    }
}
