package com.test.all.altest;

import java.util.ArrayList;

public class ArrayQueue {
    private Object[] array;
    private int capacity;
    private int size;
    private int putIndex;
    private int takeIndex;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        array = new Object[capacity];
    }

    public Object take() {
        if (size == 0) {
            return null;
        }
        Object o =array[takeIndex];
        size--;
        takeIndex = (takeIndex + 1) % capacity;
        return o;
    }

    public boolean put(Object o) {
        if (size == capacity) {
            return false;
        }
        array[putIndex] = o;
        size++;
        putIndex = (putIndex + 1) % capacity;
        return true;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.put(1);
        arrayQueue.put(2);
        arrayQueue.put(3);
        arrayQueue.put(4);
        System.err.println(arrayQueue.take());
        arrayQueue.put(5);
        Object o = arrayQueue.take();
        while (o != null) {
            System.err.println(o);
            o = arrayQueue.take();
        }
    }
}
