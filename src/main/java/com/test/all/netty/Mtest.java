package com.test.all.netty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Mtest {
    public static void main(String[] args) {
        int[][] intervals = {{1,2},{1,3},{3,5},{4,6},{7,9}};
//        merge2(intervals);
//        System.err.println(Arrays.toString(merge3(intervals)) );
        Arrays.stream(merge3(intervals)).forEach(x-> System.err.println(Arrays.toString(x)));

    }
    private static int[][] merge3(int[][] intervals){
        if (intervals.length <= 1) {
            return intervals;
        }
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(x,y)->{return x[0]-y[0];});
        for(int i=0;i<intervals.length-1;i++){
           int start = intervals[i][0];
           int end = intervals[i][1];
            while (i<intervals.length-1&& intervals[i+1][0]<end){
                end =Math.max(end,intervals[i+1][1]);
                i++;
            }
            list.add(new int[]{start,end});
        }

        return list.toArray(new int[1][1]);
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a1, int[] a2) {
                return a1[0] - a2[0];
            }
        });

        List<int[]> list = new ArrayList<>();
        for(int i = 0; i < intervals.length; i ++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            while(i < intervals.length - 1 && intervals[i + 1][0] <= end) {
                end = Math.max(end, intervals[i + 1][1]);
                //优化，如果合并过后，第i + 1个就不用再去遍历一遍了
                i ++;
            }
            list.add(new int[] {start, end});
        }
        return list.toArray(new int[0][0]);
    }

    private static int[][] merge2(int[][] intervals) {
        //边界判断
        if (intervals.length <= 1) {
            return intervals;
        }

        //先按起点位置进行排序
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        //利用list存储合并好的区间
        List<int[]> result = new ArrayList<>();
        //初始时将第一个区间放入list中
        result.add(intervals[0]);
        //记录上一合并好的区间在list中的位置
        int last = 0;
        //遍历并合并后面各区间
        for (int i = 1; i < intervals.length; i++) {
            //上一合并好的区间的起点和终点
            int lastStart = result.get(last)[0];
            int lastEnd = result.get(last)[1];
            //当前要合并的区间的起点和终点
            int start = intervals[i][0];
            int end = intervals[i][1];
            //如果左边重合
            if (lastStart == start) {
                if (end > lastEnd) {
                    result.set(last, new int[] {start, end});
                }

            } else {    //如果左边不重合
                if (start > lastEnd) {
                    result.add(new int[] {start, end});
                    last++;
                } else {
                    if (end > lastEnd) {
                        result.set(last, new int[] {lastStart, end});
                    }
                }
            }
        }

        return result.toArray(new int[0][]);
    }

}
