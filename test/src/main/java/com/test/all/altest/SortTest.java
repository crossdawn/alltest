package com.test.all.altest;

import java.util.Arrays;

public class SortTest {
    public static void main(String[] args) {
        int[] array = {1, 3, 5, 2, 4};
        quickSort(array, 0, array.length - 1);
        System.err.println(Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void insertSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int index = partition(array, low, high);
        quickSort(array, low, index - 1);
        quickSort(array, index + 1, high);
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i =low;
        int j= high;
        while (i < j) {
            while (i < j && array[j]>=pivot) {
                j--;
            }
            array[i] = array[j];
            while (i < j && pivot >= array[i]) {
                i++;
            }
            array[j] = array[i];
        }
        array[i] = pivot;
        return i;
    }


}
