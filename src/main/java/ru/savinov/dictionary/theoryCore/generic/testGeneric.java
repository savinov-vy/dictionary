package ru.savinov.dictionary.theoryCore.generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class testGeneric {

    public static void main(String[] args) {
        List<?> result = new LinkedList<>();
        ArrayList<Car> listCar = new ArrayList<>();
        listCar.add(new Car("red", 40000));
        listCar.add(new Car("white", 10000));

        ArrayList<Animal> listAnimal = new ArrayList<>();
        listAnimal.add(new Animal("Barsik", 3));
        listAnimal.add(new Animal("Bobik", 7));

        AccumulatorAllType accumulatorAllType = new AccumulatorAllType();
        accumulatorAllType.add(listAnimal);
        accumulatorAllType.add(listCar);
        System.out.println("Результат " + accumulatorAllType);

        AccumulatorOneType<Car> accumulatorOneTypeAuto = new AccumulatorOneType<>();
        accumulatorOneTypeAuto.add(listCar);

        AccumulatorOneType<Animal> animalAccumulatorOneTypeAnimal = new AccumulatorOneType<>();
        animalAccumulatorOneTypeAnimal.add(listAnimal);
        System.out.println("Результат cписок животных " + animalAccumulatorOneTypeAnimal + "\n"+
                           "Результат список машин " + accumulatorOneTypeAuto);
    }
}

class AccumulatorAllType {
    List<?> result = new ArrayList<>();

    @Override
    public String toString() {
        return super.toString();
    }

    public void add(List addition) {

        result.addAll(addition);


    }
}

class AccumulatorOneType<T> {
    List<T> result = new ArrayList<>();

    public void add(List<T> addition) {
        result.addAll(addition);
    }
}
