package ru.savinov.dictionary.backend.algorithms.hhru;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class Main {

    Set<Integer> isChecked = new HashSet<>();
    int[] valueByIndex;
    Map<Integer, Set<Integer>> indexesByValue = new HashMap<>();
    BlockingQueue<Island> toFindQueue = new ArrayBlockingQueue<>(30000);
    BlockingQueue<Island> neighboursQueue = new ArrayBlockingQueue<>(30000);
    volatile boolean isFounded = false;

    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        String[] s = line.split(" ");
        Main main = new Main();

        int[] valueByIndex = Arrays.stream(s)
                .mapToInt(Integer::valueOf)
                .toArray();
        main.setValueByIndex(valueByIndex);
        main.fillIndexesByValue(valueByIndex);

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.submit(main::fillIslandsQueue);
        executorService.submit(main::foundedTarget);

        if (executorService.awaitTermination(950, TimeUnit.MILLISECONDS)) {
        } else {
            executorService.shutdownNow();
        }

    }

    public void setValueByIndex(int[] valueByIndex) {
        this.valueByIndex = valueByIndex;
    }

    private void fillIslandsQueue() {
        try {
            Island current = new Island(valueByIndex[0], 0, 0);
            neighboursQueue.add(current);
            toFindQueue.add(current);
            isChecked.add(current.getIndex());
            while (!isFounded) {
                Island island = neighboursQueue.take();
                Set<Island> neighboursIslands = getNeighboursIslands(island);
                for (Island neighbor : neighboursIslands) {
                    if (!isChecked.contains(neighbor.getIndex())) {
                        neighboursQueue.put(neighbor);
                        toFindQueue.put(neighbor);
                        isChecked.add(neighbor.getIndex());
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private Set<Island> getNeighboursIslands(Island island) {

        int i = island.getIndex();
        int value = island.getValue();
        Set<Integer> neighbours = new HashSet<>();
        if (i > 0 && i < valueByIndex.length - 1) {
            int onLeft = i - 1;
            int onRight = i + 1;
            neighbours.add(onLeft);
            neighbours.add(onRight);
            Set<Integer> indexes = indexesByValue.get(value);
            neighbours.addAll(indexes);
        } else if (i == 0) {
            if (valueByIndex.length > 1) {
                int onRight = i + 1;
                neighbours.add(onRight);
            }
            Set<Integer> indexes = indexesByValue.get(value);
            neighbours.addAll(indexes);
        } else if (i == valueByIndex.length - 1) {
            int onLeft = i - 1;
            neighbours.add(onLeft);
            Set<Integer> indexes = indexesByValue.get(value);
            neighbours.addAll(indexes);
        }
        return neighbours.stream()
                .map(n -> new Island(valueByIndex[n], n, island.getLevel() + 1))
                .collect(Collectors.toSet());
    }

    private void foundedTarget() {
        try {
            int targetIndex = valueByIndex.length - 1;
            while (!isFounded) {
                Island current = toFindQueue.take();
                if (current.getIndex() == targetIndex) {
                    System.out.println(current.getLevel());
                    isFounded = true;
                    break;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void fillIndexesByValue(int[] s) {
        for (int i = 0; i < s.length; i++) {
            int current = s[i];
            if (!indexesByValue.containsKey(current)) {
                Set<Integer> indexes = new HashSet<>();
                indexes.add(i);
                indexesByValue.put(current, indexes);
            } else {
                Set<Integer> set = indexesByValue.get(current);
                set.add(i);
            }
        }
    }

    class Island {
        private final int value;
        private final int index;
        private Integer level;

        public Island(int value, int index, int level) {
            this.value = value;
            this.index = index;
            this.level = level;
        }

        public Integer getLevel() {
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

