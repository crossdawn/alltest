package com.test.all.way;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Pt {
    public static void main(String[] args) {
        System.err.println((int)'A');
    }
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            count[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                priorityQueue.add(count[i]);
            }
        }
        int result = 0;
        while (!priorityQueue.isEmpty()) {
            int i = 0;
            List<Integer> list = new ArrayList<>();
            while (i <= n) {
                if (!priorityQueue.isEmpty()) {
                    if (priorityQueue.peek() > 1) {
                        list.add(priorityQueue.poll() - 1);
                    } else {
                        priorityQueue.poll();
                    }
                }
                result++;
                if (priorityQueue.isEmpty() && list.size() == 0) {
                    break;
                }
                i++;
            }
            for (Integer integer : list) {
                priorityQueue.add(integer);
            }
        }
        return result;
    }

}
