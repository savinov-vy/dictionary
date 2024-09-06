package ru.savinov.dictionary.backend.algorithms.hhru;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {

    static Set<Integer> isChecked = new HashSet<>();
    static int[] valueByIndex;
    static Map<Integer, Set<Integer>> indexesByValue = new HashMap<>();
    static Deque<Island> islandsQueue = new ArrayDeque<>();
    static Boolean isFounded = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        String[] s = line.split(" ");

        valueByIndex = Arrays.stream(s)
                .mapToInt(Integer::valueOf)
                .toArray();
        fillIndexesByValue(valueByIndex);
        foundedTarget();
    }

    static void foundedTarget() {
        Island current = new Island(valueByIndex[0], 0, 0);
        islandsQueue.add(current);

        int targetIndex = valueByIndex.length - 1;
        while (!isFounded) {
            current = islandsQueue.poll();
            if (isChecked.contains(current)) {
                continue;
            }
            if (current.getIndex() == targetIndex) {
                System.out.println(current.getLevel());
                isFounded = true;
                break;
            }

            int index = current.getIndex();
            isChecked.add(index);
            putNeighboursToQueue(current);
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

    static Integer[] getNeighboursIndexesByIsland(Island island) {
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

        Integer[] n = new Integer[neighbours.size()];
        neighbours.toArray(n);
        return n;
    }

    private static void putNeighboursToQueue(Island current) {
        int currentLevel = current.getLevel();
        Integer[] neighboursIslands = getNeighboursIndexesByIsland((current));
        for (int neighbour : neighboursIslands) {
            if (isChecked.contains(neighbour)) {
                continue;
            }
            islandsQueue.add(new Island(valueByIndex[neighbour], neighbour, currentLevel + 1));
        }
    }

    static class Island {
        private final int value;
        private final int index;
        private int level;

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

        public int getIndex() {
            return index;
        }

    }
}
