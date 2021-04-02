package com.test.all.altest;

public class TwoQueueStack {
    private ArrayQueue q1;
    private ArrayQueue q2;
    private int capacity;
    private int size;

    public TwoQueueStack(int capacity) {
        this.capacity = capacity;
        this.q1 = new ArrayQueue(capacity);
        this.q2 = new ArrayQueue(capacity);
    }

    public Object pop() {
        if (size == 0) {
            return null;
        }
        Object o = null;
        if (q1.size() > 0 && q2.size() == 0) {
            while (q1.size() > 1) {
                q2.put(q1.take());
            }
            size--;
            o = q1.take();
        } else if (q1.size() == 0 && q2.size() > 0) {
            while (q2.size() > 1) {
                q1.put(q2.take());
            }
            size--;
            o = q2.take();
        }
        return o;
    }

    public boolean push(Object o) {
        if (size == capacity) {
            return false;
        }
        size++;
        if (q1.size() == 0) {
            return q2.put(o);
        } else {
            return q1.put(o);
        }
    }

    public static void main(String[] args) {
        TwoQueueStack arrayStack = new TwoQueueStack(3);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.pop();
        arrayStack.push(5);
        Object o = arrayStack.pop();
        while (o != null) {
            System.err.println(o);
            o = arrayStack.pop();
        }
    }
}
