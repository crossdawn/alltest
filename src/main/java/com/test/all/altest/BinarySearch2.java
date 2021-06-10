package com.test.all.altest;

/**
 * 利用二分法查找有序数组中某个数出现的次数
 * 最后一次出现-第一次出现+1
 */
public class BinarySearch2 {

//    public static void main(String[] args) {
//        int[] array = {1, 2, 3, 3, 4, 5};
//        int first = getFirst(array, 3, 0, array.length - 1);
//        int last = getLast(array, 3, 0, array.length - 1);
//        int count = 0;
//        if (first != -1) {
//            count = last - first + 1;
//        }
//        System.err.println(count);
//    }

    private static int getFirst(int[] array, int k, int begin, int end) {
        while (begin <= end) {
            int middle = (begin + end) / 2;
            if (array[middle] == k) {
                if ((middle > 0 && array[middle - 1] != k) || middle == 0) {
                    return middle;
                } else {
                    end = middle - 1;
                }
            } else if (array[middle] > k) {
                end = middle - 1;
            } else {
                begin = middle + 1;
            }
        }
        return -1;
    }

    private static int getLast(int[] array, int k, int begin, int end) {
        while (begin <= end) {
            int middle = (begin + end) / 2;
            if (array[middle] == k) {
                if ((middle < array.length - 1 && array[middle + 1] != k) || middle == array.length - 1) {
                    return middle;
                } else {
                    begin = middle + 1;
                }
            } else if (array[middle] > k) {
                end = middle - 1;
            } else {
                begin = middle + 1;
            }
        }
        return -1;
    }


    private static int getFirst1(int[] array, int k, int begin, int end) {
        while(begin<end){
            int middle = (end+begin)/2;
            if(array[middle]==k&&array[middle-1]!=k||middle==0){
                return middle;
            }else if(array[middle]>k){
                end = middle-1;
            }else {
                begin =middle+1;
            }
        }
        return -1;
    }

    private static boolean getInt(int[][] matrix,int k){
        int rowMax = matrix.length;
        int columMax = matrix[0].length;
        int row =0;
        int cloum =columMax-1;
        while (true){
            if(row<0||cloum<0||row>=rowMax||cloum>=columMax){
                return false;
            }else if(matrix[row][cloum]==k){
                return true;
            }else if(matrix[row][cloum]>k){
                    cloum--;
            }else {
                    row++;
            }
        }
    }

    public static void main(String[] args) {
        int[][] data = {{1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}};
        System.out.println(getInt(data, 15));
        System.out.println(getInt(data, 5));

    }


}
