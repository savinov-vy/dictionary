package ru.savinov.dictionary.backend.algorithms;

import java.util.Arrays;

public class Quick_sort_lomuto {
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Разделение по схеме Lomuto
    public static int partition(int[] a, int start, int end) {
        // Выбираем крайний правый элемент в качестве опорного элемента массива
        int pivot = a[end];

        // элементы, меньшие точки поворота, будут перемещены влево от pIndex
        // элементы больше, чем точка поворота, будут сдвинуты вправо от pIndex
        // равные элементы могут идти в любом направлении
        int pIndex = start;

        // каждый раз, когда мы находим элемент, меньший или равный опорному,
        // pIndex увеличивается, и этот элемент будет помещен
        // перед разворотом.
        for (int i = start; i < end; i++) {
            if (a[i] <= pivot) {
                swap(a, i, pIndex);
                pIndex++;
            }
        }

        // поменять местами pIndex с пивотом
        swap(a, end, pIndex);

        // вернуть pIndex (индекс опорного элемента)
        return pIndex;
    }

    // Процедура быстрой сортировки
    public static void quicksort(int[] a, int start, int end) {
        // базовое условие
        if (start >= end) {
            return;
        }

        // переставить элементы по оси
        int pivot = partition(a, start, end);

        // повторяемся на подмассиве, содержащем меньше элементов, чем опорный
        quicksort(a, start, pivot - 1);

        // повторяем подмассив, содержащий элементов больше, чем опорный
        quicksort(a, pivot + 1, end);
    }

    public static void main(String[] args) {
        int[] a = {5,13,1,31,25,17,3,11,14,7,19,20,2,32,9,16,22,28,15,21,10,27,4,6,26,18,8,29,12,24,30,23};

        quicksort(a, 0, a.length - 1);

        // печатаем отсортированный массив
        System.out.println(Arrays.toString(a));
    }
}