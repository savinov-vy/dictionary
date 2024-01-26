package ru.savinov.dictionary.backend.algorithms;

import java.util.Arrays;

public class Quick_sort_hoara {

    public static void main(String[] args) {
//        int[] x = {5,13,1,31,25,17,3,11,14,7,19,20,2,32,9,16,22,28,15,21,10,27,4,6,26,18,8,29,12,24,30,23};
        int[] x = {1,4,3,0,5,6,2};
        System.out.println("Было");
        System.out.println(Arrays.toString(x));

        int low = 0;
        int high = x.length - 1;

        quickSort(x, low, high);
        System.out.println("Стало");
        System.out.println(Arrays.toString(x));

    }

    public static void quickSort(int[] array, int leftBorder, int rightBorder) {
        if (array.length == 0)
            return;//завершить выполнение, если длина массива равна 0

        if (leftBorder >= rightBorder)
            return;//завершить выполнение если уже нечего делить

        // выбрать опорный элемент
        int middle = leftBorder + (rightBorder - leftBorder) / 2;
        int pivot = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        while (leftMarker <= rightMarker) {
            while (array[leftMarker] < pivot) {
                leftMarker++;
            }

            while (array[rightMarker] > pivot) {
                rightMarker--;
            }

            if (leftMarker <= rightMarker) {//меняем местами
                int temp = array[leftMarker];
                array[leftMarker] = array[rightMarker];
                array[rightMarker] = temp;
                leftMarker++;
                rightMarker--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (leftBorder < rightMarker)
            quickSort(array, leftBorder, rightMarker);

        if (rightBorder > leftMarker)
            quickSort(array, leftMarker, rightBorder);
    }
}