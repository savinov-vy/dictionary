package ru.savinov.dictionary.backend.algorithms.backpack;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BackPack {
    public static void main(String[] args) throws FileNotFoundException {
        String PATH_TO_FILE = "src/main/java/ru/savinov/dictionary/backend/algorithms/backpack/source.txt";
        Scanner sc = new Scanner(new FileReader(PATH_TO_FILE));
//        Scanner sc = new Scanner(System.in);
        String firstLine = sc.nextLine();
        String[] countAndCapacity = firstLine.split(" ");
        Integer amountThings = Integer.valueOf(countAndCapacity[0]);
        Integer capacityBackPack = Integer.valueOf(countAndCapacity[1]);

        List<Integer[]> allThings = new ArrayList<>(amountThings);
        for (int i = 1; i <= amountThings; i++) {
            Integer[] thing = new Integer[2];
            String line = sc.nextLine();
            String[] valueAndCapacityThings = line.split(" ");
            thing[0] = Integer.valueOf(valueAndCapacityThings[0]);
            thing[1] = Integer.valueOf(valueAndCapacityThings[1]);
            allThings.add(thing);
        }
        //sort all things by unit cost
        Collections.sort(allThings, (o1, o2) -> o2[0] * o1[1] - o1[0] * o2[1]);

        //fill backpack whole things
        int numOfThing = 0;
        int amountCostBackPack = 0;
        int amountWeight = allThings.get(numOfThing)[1];
        while (amountWeight <= capacityBackPack) {
            amountCostBackPack += allThings.get(numOfThing)[0];
            numOfThing++;
            if (numOfThing < allThings.size()) {
                amountWeight += allThings.get(numOfThing)[1];
            } else break;
        }
        // fill backpack part thing
        double result = amountCostBackPack;
        if (numOfThing < allThings.size()) {
            Integer[] thingToCut = allThings.get(numOfThing);
            int excess = amountWeight - capacityBackPack;
            double volumeLastThing = ((double) (thingToCut[1] - excess) / (thingToCut[1])) * thingToCut[0];
            result = amountCostBackPack + volumeLastThing;
        }
        System.out.println(result);
    }
}
