package ru.savinov.dictionary.backend.algorithms.hhru;

import java.util.ArrayList;
import java.util.Arrays;
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
    static BlockingQueue<Island> toFindQueue = new ArrayBlockingQueue<>(5000);
    static BlockingQueue<Island> neighboursQueue = new ArrayBlockingQueue<>(5000);
    static ExecutorService executorServiceProducer;
    static ExecutorService executorServiceConsumer;
    static boolean isFounded = false;

    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] s = line.split(" ");
        valueByIndex = Arrays.stream(s)
                .mapToInt(Integer::valueOf)
                .toArray();

        fillIndexesByValue(valueByIndex);

        int halfAvailableProcessors = Runtime.getRuntime().availableProcessors() / 2;
        executorServiceProducer = Executors.newFixedThreadPool(halfAvailableProcessors);
        executorServiceConsumer = Executors.newFixedThreadPool(halfAvailableProcessors);

        Main main = new Main();

        executorServiceProducer.submit(main::fillIslandsQueue);
        executorServiceConsumer.submit(main::foundedTarget);
        executorServiceProducer.shutdown();
        executorServiceConsumer.shutdown();
    }

    private void fillIslandsQueue() {
        try {
            Island current = new Island(valueByIndex[0], 0, 0);
            neighboursQueue.add(current);
            toFindQueue.add(current);
            isChecked.add(current.getIndex());
            while (!isFounded) {
                Island island = neighboursQueue.take();
                if (island != null) {
                    List<Island> neighboursIslands = getNeighboursIslands(island);
                    for (Island neighbor : neighboursIslands) {
                        if (!isChecked.contains(neighbor.getIndex())) {
                            neighboursQueue.put(neighbor);
                            toFindQueue.put(neighbor);
                            isChecked.add(neighbor.getIndex());
                        }
                    }
                }
            }
        } catch (InterruptedException e) {}
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
        for (Integer n : neighbours) {
            if (isChecked.contains(n)) {
                continue;
            }
            islands.add(new Island(valueByIndex[n], n, island.getLevel() + 1));
        }
        return islands;
    }

    private void foundedTarget() {
        try {
            int targetIndex = valueByIndex.length - 1;
            while (!isFounded) {
                Island current = toFindQueue.take();
                if (current != null) {
                    if (current.getIndex() == targetIndex) {
                        System.out.println(current.getLevel());
                        isFounded = true;
                        executorServiceProducer.shutdownNow();
                        executorServiceConsumer.shutdownNow();
                    }
                }

            }
        } catch (InterruptedException e) {}
    }

    private static void fillIndexesByValue(int[] s) {
        for (int i = 0; i < s.length; i++) {
            int current = s[i];
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

