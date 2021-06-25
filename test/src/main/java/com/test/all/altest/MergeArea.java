package com.test.all.altest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeArea {
    public static void main(String[] args) {
        int[][] intervals = {{1, 2}, {1, 3}, {3, 5}, {4, 6}, {7, 9}};
        Arrays.stream(merge(intervals)).forEach(x -> System.err.println(Arrays.toString(x)));
    List list = new ArrayList<String>();
    list.add(1);
    }


    private static int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (x, y) -> {
            return x[0] - y[0];
        });
        for (int i = 0; i < intervals.length; i++) {
            int begin = intervals[i][0];
            int end = intervals[i][1];
            while (i < intervals.length - 1 && intervals[i + 1][0] < end) {
                end = Math.max(end, intervals[i + 1][1]);
                i++;
            }
            result.add(new int[]{begin, end});
        }
        return result.toArray(new int[][]{});
    }
}
