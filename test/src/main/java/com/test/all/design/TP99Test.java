package com.test.all.design;

import java.util.*;

/**
 * 1-----90---100
 */
public class TP99Test {

    private final int tpN;
    private int count;

    public TP99Test(int tpN) {
        this.tpN = tpN;
    }

    private final PriorityQueue<Integer> bigPriorityQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);

    private final PriorityQueue<Integer> smallPriorityQueue = new PriorityQueue<>((o1, o2) -> o1 - o2);

    public void add(int time) {
        count++;
        if (bigPriorityQueue.size() == 0) {
            bigPriorityQueue.add(time);
            return;
        }
        Integer bigData = bigPriorityQueue.peek();
        if (time < bigData) {
            bigPriorityQueue.add(time);
        } else {
            smallPriorityQueue.add(time);
        }

        //移动元素 保持比例
        int bigSize = bigPriorityQueue.size();
        int move = (int) (count * tpN / 100f - bigSize);
        if (move > 0) {
            move(smallPriorityQueue, bigPriorityQueue, move);
        } else if (move < 0) {
            move(bigPriorityQueue, bigPriorityQueue, Math.abs(move));
        }
    }

    public void move(PriorityQueue<Integer> from, PriorityQueue<Integer> to, int count) {
//        System.err.println("移动:"+from.size()+"到:"+to.size()+"总共:"+count);
        for (int i = 0; i < count; i++) {
            to.add(from.poll());
        }
    }

    public int get() {
        Integer tpN = bigPriorityQueue.peek();
        print();
        return tpN;
    }



    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        TP99Test tp99Test = new TP99Test(50);
        for (int i = 1; i <= 100; i++) {
            int a  = new Random().nextInt(500);
            list.add(a);
            tp99Test.add(a);
        }
        System.err.println(tp99Test.get());
        System.err.println("list"+list);

        Collections.sort(list);        System.err.println("list2"+list);

        StringJoiner bigSj = new StringJoiner(",");
        list.forEach(x->bigSj.add(x+""));
        System.err.println("aaa"+bigSj);
        System.err.println(list.get(50));
        System.err.println(tp99Test.get());
    }

    private void print() {
//        int bigSize = bigPriorityQueue.size();
//        StringJoiner bigSj = new StringJoiner(",");
//        for (int i = 0; i < bigSize; i++) {
//            bigSj.add(bigPriorityQueue.poll() + "");
//            bigPriorityQueue.toString()
//        }
//        System.err.println(bigPriorityQueue);


//        int smallSize = smallPriorityQueue.size();
//        StringJoiner stringJoiner = new StringJoiner(",");
//        for (int i = 0; i < smallSize; i++) {
//            stringJoiner.add(smallPriorityQueue.poll() + "");
//        }
//        System.err.println(stringJoiner);
//        System.err.println(smallPriorityQueue);

    }

}
