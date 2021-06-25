package com.test.all.altest;

import java.util.Arrays;

public class MergeSortArray {
    public static void main(String[] args) {
        int[] array1 = {1, 3, 5, 7, 9};
        int[] array2 = {2, 4, 6};
        int[] result = merge(array1, array2);
        System.err.println(Arrays.toString(result));
    }

    private static int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        while (index1 < array1.length && index2 < array2.length) {
            if (array1[index1] < array2[index2]) {
                result[index3++] = array1[index1++];
            } else {
                result[index3++] = array2[index2++];
            }
        }
        while (index1 < array1.length) {
            result[index3++] = array1[index1++];
        }
        while (index2 < array2.length) {
            result[index3++] = array2[index2++];
        }
        return result;
    }

}
