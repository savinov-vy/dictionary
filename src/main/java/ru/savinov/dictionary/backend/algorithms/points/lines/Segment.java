package ru.savinov.dictionary.backend.algorithms.points.lines;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    private static List<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        int[][] segments = fillStackLines();
        Arrays.sort(segments, Comparator.comparingInt(a -> a[1]));

        boolean isStop = false;
        int endPoint = -1;
        while (!isStop) {
            if (endPoint == -1) {
                endPoint = findFirstPoint(segments);
                result.add(endPoint);
            }
            int minStartPointNotBelongToSegmentByPoint = findMinStartPointNotBelongToSegmentByPoint(segments, endPoint);
            int minEndPointByStartPoint = findMinEndPointByStartPoint(segments, minStartPointNotBelongToSegmentByPoint);
            endPoint = minEndPointByStartPoint;
            if (minEndPointByStartPoint == -1) {
                isStop = true;
            } else {
                result.add(minEndPointByStartPoint);
            }
        }
        System.out.println(result.size());
        System.out.println(joinToString(result));
    }

    private static int findFirstPoint(int[][] segments) {
        return segments[0][1];
    }

    private static int findMinStartPointNotBelongToSegmentByPoint(int[][] segments, int endPoint) {
        for (int i = 0; i < segments.length; i++) {
            int startPoint = segments[i][0];
            if (endPoint < startPoint) {
                return startPoint;
            }
        }
        return -1;
    }

    private static int findMinEndPointByStartPoint(int[][] segments, int startPoint) {
        for (int i = 0; i < segments.length; i++) {
            if (startPoint == segments[i][0]) {
                return segments[i][1];
            }
        }
        return -1;
    }

    private static int[][] fillStackLines() throws FileNotFoundException {
        String PATH_TO_FILE = "src/main/java/ru/savinov/dictionary/backend/algorithms/points/lines/source.txt";
        Scanner sc = new Scanner(System.in);
        int countSegments = Integer.parseInt(sc.nextLine());
        int[][] segments = new int[countSegments][2];
        for (int i = 0; i < countSegments; i++) {
            String line = sc.nextLine();
            int segment[] = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::valueOf)
                    .toArray();
            segments[i] = segment;
        }
        return segments;
    }

    private static String joinToString(List<Integer> result) {
        return result.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }
}

