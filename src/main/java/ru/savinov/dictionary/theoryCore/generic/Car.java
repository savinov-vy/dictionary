package ru.savinov.dictionary.theoryCore.generic;

public class Car implements Moveable {

    private String color;
    private int mileAge;

    public Car(String color, int mileAge) {
        this.color = color;
        this.mileAge = mileAge;
    }

    public Car() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMileAge() {
        return mileAge;
    }

    public void setMileAge(int mileAge) {
        this.mileAge = mileAge;
    }

    @Override
    public void move() {

    }


}
