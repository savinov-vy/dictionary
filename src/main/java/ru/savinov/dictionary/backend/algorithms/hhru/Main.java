package ru.savinov.dictionary.backend.algorithms.hhru;

import ru.savinov.dictionary.backend.algorithms.hhru.max_area.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    static Set<Integer> isChecked = new HashSet<>();
    static int[] valueByIndex;
    static Map<Integer, List<Integer>> indexesByValue = new HashMap<>();
    static BlockingQueue<Island> checkedQueue = new ArrayBlockingQueue<>(10000, true);
    static BlockingQueue<Island> toCheckQueue = new ArrayBlockingQueue<>(10000, true);
    static ExecutorService executorServiceProducer;
    static ExecutorService executorServiceConsumer;
    static volatile boolean isFounded = false;
    static int targetIndex;
//    static long start;

    public static void main(String[] args) throws InterruptedException {
//        start = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);
        String line = Data.testAllSame_plus; //in.nextLine();
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

        executorServiceProducer = Executors.newSingleThreadExecutor();
        executorServiceConsumer = Executors.newSingleThreadExecutor();

        Main main = new Main();

        main.fillIndexesByValue();

        if (indexesByValue.size() == 1) {
            System.out.println(1);
            return;
        }
        executorServiceProducer.execute(main::putToQueueOnCheck);
        executorServiceConsumer.execute(main::checkIsland);
        executorServiceProducer.shutdown();
        executorServiceConsumer.shutdown();
    }

    private void putToQueueOnCheck() {
        checkedQueue.add(new Island(0, 0));
        isChecked.add(0);
        try {
            while (!isFounded) {
                Island island = checkedQueue.take();
                Set<Integer> neighboursIslands = getNeighboursIslandIndexes(island.getIndex());
                for (Integer neighborIndex : neighboursIslands) {
                    if (!isChecked.contains(neighborIndex)) {
                        Island neighbor = new Island(neighborIndex, island.getLevel() + 1);
                        toCheckQueue.put(neighbor);
                    }
                }
                isChecked.addAll(neighboursIslands);
            }
        } catch (InterruptedException e) {
        }
    }

    private synchronized void checkIsland() {
        try {
            while (!isFounded) {
                Island island = toCheckQueue.take();
                int currentIndex = island.getIndex();
                if (currentIndex == targetIndex) {
                    System.out.println(island.getLevel());
                    isFounded = true;
                    executorServiceProducer.shutdownNow();
                    executorServiceConsumer.shutdownNow();
//                    System.out.println(System.currentTimeMillis() - start);
                }
                checkedQueue.put(island);
            }
        } catch (
                InterruptedException e) {
        }
    }

    private Set<Integer> getNeighboursIslandIndexes(int index) {
        Set<Integer> neighbours = new HashSet<>();
        if (index > 0 && index < valueByIndex.length - 1) {
            int onLeft = index - 1;
            int onRight = index + 1;
            neighbours.add(onLeft);
            neighbours.add(onRight);
            List<Integer> indexes = indexesByValue.get(valueByIndex[index]);
            neighbours.addAll(indexes);
        } else if (index == 0) {
            int onRight = index + 1;
            neighbours.add(onRight);
            List<Integer> indexes = indexesByValue.get(valueByIndex[index]);
            neighbours.addAll(indexes);
        } else if (index == valueByIndex.length - 1) {
            int onLeft = index - 1;
            neighbours.add(onLeft);
            List<Integer> indexes = indexesByValue.get(valueByIndex[index]);
            neighbours.addAll(indexes);
        }
        return neighbours;
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
        private final int index;
        private final int level;

        public Island(int index, int level) {
            this.index = index;
            this.level = level;
        }

        public int getLevel() {
            return level;
        }

        public int getIndex() {
            return index;
        }
    }
}

