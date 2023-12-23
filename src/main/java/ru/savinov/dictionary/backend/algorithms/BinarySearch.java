package ru.savinov.dictionary.backend.algorithms;

/**
 * существует отсортированный массив
 * Найти индекс искомого числа в массиве
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {-5, -3, 0, 2, 10, 25, 84, 341, 425, 521, 687, 786, 999};

        int index = binarySearch(arr, 25);
        System.out.println(index);
    }

    private static int binarySearch(int[] arr, int key) {
        int leftBorder = 0;
        int rightBorder = arr.length - 1;

        while (leftBorder <= rightBorder) {
            int middlePointer = leftBorder + (rightBorder - leftBorder)/2;

            if (key < arr[middlePointer]) {
                rightBorder = middlePointer - 1;
            } else if (key > arr[middlePointer]) {
                leftBorder = middlePointer + 1;
            } else {
                return middlePointer;
            }
        }
        return -1;
    }
}
