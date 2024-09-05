package ru.savinov.dictionary.backend.algorithms.hhru;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

public class Main {

    static Set<Integer> isChecked = new HashSet<>();
    static Map<Island, Set<Integer>> neighboursByIsland = new HashMap<>();
    static int[] valueByIndex;
    static Map<Integer, Set<Integer>> indexesByValue = new HashMap<>();
    static BlockingQueue<Island> islandsQueue = new ArrayBlockingQueue<>(10);
    static BlockingQueue<Integer> toHandle = new ArrayBlockingQueue<>(10);
    static Boolean isFounded = false;

    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
//        String line = in.nextLine();
        String line = "3 2 5 2 5 2 5 3";
        String[] s = line.split(" ");
//        valueByIndex = IntStream.range(0, 52000)
//                .toArray();
        valueByIndex = Arrays.stream(s)
                .mapToInt(Integer::valueOf)
                .toArray();
        fillIndexesByValue(valueByIndex);
        fillNeighboursIndexesByIsland();
        foundedTarget();


    }

    static void foundedTarget() throws InterruptedException {
        Island current = new Island(valueByIndex[0], 0, 0);
        islandsQueue.add(current);

        int targetIndex = valueByIndex.length - 1;
        while (!isFounded) {
            current = islandsQueue.take();
            if (isChecked.contains(current)) {
                continue;
            }
            if (current.getIndex() == targetIndex) {
                System.out.println(current.getLevel());
                isFounded = true;
            }

            int index = current.getIndex();
            isChecked.add(index);
            putNeighboursToQueue(islandsQueue, current);
        }
    }

    static void fillIndexesByValue(int[] s) {
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

    static void fillNeighboursIndexesByIsland() {
        for (int i = 0; i < valueByIndex.length; i++) {
            Integer value = valueByIndex[i];
            Island current = new Island(value, i);
            Set<Integer> neighbours = new HashSet<>();
            if (i > 0 && i < valueByIndex.length - 1) {
                int onLeft = i - 1;
                int onRight = i + 1;
                neighbours.add(onLeft);
                neighbours.add(onRight);
                Set<Integer> indexes = indexesByValue.get(value);
                neighbours.addAll(indexes);
                neighboursByIsland.put(current, neighbours);
            } else if (i == 0) {
                if (valueByIndex.length > 1) {
                    int onRight = i + 1;
                    neighbours.add(onRight);
                }
                Set<Integer> indexes = indexesByValue.get(value);
                neighbours.addAll(indexes);
                neighboursByIsland.put(current, neighbours);
            } else if (i == valueByIndex.length - 1) {
                int onLeft = i - 1;
                neighbours.add(onLeft);
                Set<Integer> indexes = indexesByValue.get(value);
                neighbours.addAll(indexes);
                neighboursByIsland.put(current, neighbours);
            }

        }
    }

    private static void putNeighboursToQueue(BlockingQueue<Island> islandsQueue, Island current) throws
            InterruptedException {
        int currentLevel = current.getLevel();
        Set<Integer> neighboursIslands = neighboursByIsland.get(current);
        for (int neighbour : neighboursIslands) {
            if (isChecked.contains(neighbour)) {
                continue;
            }
            islandsQueue.put(new Island(valueByIndex[neighbour], neighbour, currentLevel + 1));
        }
//        System.out.println("Memory: " + ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory())) / 1048576); //!!!!!!!!!
    }

    static class Island {
        private final int value;
        private final int index;
        private int level;

        public Island(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public Island(int value, int index, int level) {
            this.value = value;
            this.index = index;
            this.level = level;
        }

        public int getValue() {
            return value;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getIndex() {
            return index;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Island island = (Island) o;
            return value == island.value && index == island.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, index);
        }

        @Override
        public String toString() {
            return "Island{" +
                    "value=" + value +
                    ", index=" + index +
                    ", level=" + level +
                    '}';
        }
    }
}
