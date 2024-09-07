package ru.savinov.dictionary.backend.algorithms.hhru;

import ru.savinov.dictionary.backend.algorithms.hhru.max_area.Data;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    static volatile Set<Integer> isChecked = new HashSet<>();
    static volatile int[] valueByIndex;
    static Map<Integer, Set<Integer>> indexesByValue = new ConcurrentHashMap<>();
    static volatile BlockingQueue<Island> toFindQueue = new ArrayBlockingQueue<>(1000);
    static volatile BlockingQueue<Island> neighboursQueue = new ArrayBlockingQueue<>(1000);
    static ExecutorService executorServiceProducer;
    static ExecutorService executorServiceConsumer;
    volatile static boolean isFounded = false;

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);
//        String line = in.nextLine();
        String line = Data.data1 + " " + Data.data2 + " " + Data.data3;

        String[] s = line.split(" ");

        valueByIndex = Arrays.stream(s)
                .mapToInt(Integer::valueOf)
                .toArray();

        fillIndexesByValue(valueByIndex);

        int availableProcessors1 = Runtime.getRuntime().availableProcessors() / 2;
        executorServiceProducer = Executors.newFixedThreadPool(availableProcessors1);
        int availableProcessors2 = Runtime.getRuntime().availableProcessors() / 2;
        executorServiceConsumer = Executors.newFixedThreadPool(availableProcessors2);

        Main main = new Main();

        executorServiceProducer.submit(main::fillIslandsQueue);
        executorServiceConsumer.submit(main::foundedTarget);

        long end = 0;
        if (!executorServiceConsumer.awaitTermination(900, TimeUnit.MILLISECONDS)) {
            executorServiceProducer.shutdownNow();
            executorServiceConsumer.shutdownNow();
            end = System.currentTimeMillis();
        }
        System.out.println(end - start);
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
                    Set<Island> neighboursIslands = getNeighboursIslands(island);
                    for (Island neighbor : neighboursIslands) {
                        if (!isChecked.contains(neighbor.getIndex())) {
                            neighboursQueue.put(neighbor);
                            toFindQueue.put(neighbor);
                            isChecked.add(neighbor.getIndex());
                        }
                    }
                }
            }
        } catch (InterruptedException e) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
            }
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
        Set<Island> islands = new HashSet<>();
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
                if (current.getIndex() == targetIndex) {
                    System.out.println(current.getLevel());
                    isFounded = true;
                    break;
                }
            }
        } catch (InterruptedException e) {
            try {
                Thread.sleep(2);
            } catch (InterruptedException ex) {
            }
        }
    }

    private static void fillIndexesByValue(int[] s) {
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
        private int level;

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

