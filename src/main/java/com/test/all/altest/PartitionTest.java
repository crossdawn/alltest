package com.test.all.altest;

import java.util.Arrays;

public class PartitionTest {
    public static void main(String[] args) {
        int[] array = {2, 7, 3, 2, 2};
        int p = partition(array, 0, array.length - 1);
        System.err.println(p);
        System.err.println(Arrays.toString(array));
        System.err.println(k(array, 2));
        System.err.println(middle(array));
    }

    public static int partition(int[] array, int l, int h) {
        int pivot = array[l];

        while (l < h) {
            while (l < h && pivot <= array[h]) {
                h--;
            }
            array[l] = array[h];
            while (l < h && pivot > array[l]) {
                l++;
            }
            array[h] = array[l];
        }
        array[l] = pivot;
        return l;
    }

    public static int k(int[] array, int k) {
        int index = partition(array, 0, array.length - 1);
        while (index != (k - 1)) {
            if (index > (k - 1)) {
                index = partition(array, 0, index - 1);
            } else {
                index = partition(array, index + 1, array.length - 1);
            }
        }
        return array[index];
    }

    public static int middle(int[] array) {
        int middle = array.length >> 1;
        int index = partition(array, 0, array.length - 1);
        while (index != middle) {
            if (index > (middle - 1)) {
                index = partition(array, 0, index - 1);
            } else {
                index = partition(array, index + 1, array.length - 1);
            }
        }
        int cnt = 0;
        for (int value : array) {
            if (array[index] == value) {
                cnt++;
            }
            if (cnt * 2 > array.length) {
                return array[index];
            }
        }
        return -1;
    }

}
