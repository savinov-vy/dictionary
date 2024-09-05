package ru.savinov.dictionary.backend.algorithms.hhru.max_area;

import java.util.Arrays;
import java.util.Scanner;

public class MaxArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
//        String line = "2 4 3 2 1 4 1";

        String[] s = line.split(" ");

        Integer[] fencesByIndex = Arrays.stream(s)
                .map(Integer::valueOf)
                .toArray(Integer[]::new);
        int maxValue = 0;
        for (int value : fencesByIndex) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        long maxArea = 0;
        for (int i = 0; i < fencesByIndex.length; i++) {
            for (int j = fencesByIndex.length - 1; j >= 0; j--) {
                int diff = j - i;
                int height = Math.min(fencesByIndex[i], fencesByIndex[j]);
                long currArea = (long) diff * height;
                if (currArea > maxArea) {
                    maxArea = currArea;
                }
                if (diff == 0 || (maxArea / diff) > maxValue) {
                    break;
                }
            }
        }
        System.out.println(maxArea);
    }

}
