package ru.savinov.dictionary.backend.algorithms.hhru;

import ru.savinov.dictionary.backend.algorithms.hhru.max_area.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static Set<Integer> isChecked = new HashSet<>();
    static int[] valueByIndex;
    static Map<Integer, List<Integer>> indexesByValue = new HashMap<>();
    static Queue<Island> neighboursQueue = new LinkedList<>();
    static ExecutorService executorServiceProducer;
    static boolean isFounded = false;
    static int targetIndex;
    static long start;

    public static void main(String[] args) throws InterruptedException {
        start = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);
        String line = Data.allDifferent; //in.nextLine();
        String[] numbers = line.split(" ");

        valueByIndex = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            valueByIndex[i] = Integer.parseInt(numbers[i]);
        }

        if (valueByIndex.length == 1) {
            System.out.println(0);
            return;
        }
        if (valueByIndex.length == 2) {
            System.out.println(1);
            return;
        }

        targetIndex = valueByIndex.length - 1;

        int availableProcessors = Runtime.getRuntime().availableProcessors();
        executorServiceProducer = Executors.newFixedThreadPool(availableProcessors);

        Main main = new Main();

        main.fillIndexesByValue();
        executorServiceProducer.submit(main::foundTarget);
        executorServiceProducer.shutdown();
    }

    private void foundTarget() {
            Island current = new Island(valueByIndex[0], 0, 0);
            neighboursQueue.add(current);
            isChecked.add(current.getIndex());
            while (!isFounded) {
                Island island = neighboursQueue.poll();
                List<Island> neighboursIslands = getNeighboursIslands(island);
                for (Island neighbor : neighboursIslands) {
                    if (!isChecked.contains(neighbor.getIndex())) {
                        neighboursQueue.add(neighbor);
                        isChecked.add(neighbor.getIndex());
                    }
                }
            }
    }

    private List<Island> getNeighboursIslands(Island island) {

        int i = island.getIndex();
        int value = island.getValue();
        List<Integer> neighbours = new ArrayList<>();
        if (i > 0 && i < valueByIndex.length - 1) {
            int onLeft = i - 1;
            int onRight = i + 1;
            neighbours.add(onLeft);
            neighbours.add(onRight);
            List<Integer> indexes = indexesByValue.get(value);
            neighbours.addAll(indexes);
        } else if (i == 0) {
            if (valueByIndex.length > 1) {
                int onRight = i + 1;
                neighbours.add(onRight);
            }
            List<Integer> indexes = indexesByValue.get(value);
            neighbours.addAll(indexes);
        } else if (i == valueByIndex.length - 1) {
            int onLeft = i - 1;
            neighbours.add(onLeft);
            List<Integer> indexes = indexesByValue.get(value);
            neighbours.addAll(indexes);
        }
        List<Island> islands = new ArrayList<>();
        for (Integer indexNeighbour : neighbours) {
            if (isChecked.contains(indexNeighbour)) {
                continue;
            }
            int currentLevel = island.getLevel();
            boolean check = check(currentLevel, indexNeighbour);
            if (check) {
                break;
            }
            islands.add(new Island(valueByIndex[indexNeighbour], indexNeighbour, currentLevel + 1));
            System.out.println("Memory 2: " + ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())) / 1048576); //!!!!!!!!!
        }
        return islands;
    }

    private boolean check(int currentLevel, int indexNeighbour) {
        if (!isChecked.contains(indexNeighbour)) {
            if (indexNeighbour == targetIndex) {
                System.out.println(currentLevel + 1);
                isFounded = true;
                executorServiceProducer.shutdownNow();
                System.out.println(System.currentTimeMillis() - start);
            }
        }
        return isFounded;
    }

    private void fillIndexesByValue() {
        for (int i = 0; i < valueByIndex.length; i++) {
            int current = valueByIndex[i];
            if (!indexesByValue.containsKey(current)) {
                List<Integer> indexes = new ArrayList<>();
                indexes.add(i);
                indexesByValue.put(current, indexes);
            } else {
                List<Integer> set = indexesByValue.get(current);
                set.add(i);
            }
        }
    }

    class Island {
        private final int value;
        private final int index;
        private final int level;

        public Island(int value, int index, int level) {
            this.value = value;
            this.index = index;
            this.level = level;
        }

        public int getLevel() {
            return level;
        }

        public int getValue() {
            return value;
        }

        public int getIndex() {
            return index;
        }
    }
}

