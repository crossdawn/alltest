package com.test.all.altest;

public class TwoStackQueue {
    private ArrayStack s1;
    private ArrayStack s2;
    private int capacity;
    private int size;

    public TwoStackQueue(int capacity){
        this.capacity=capacity;
        this.s1 = new ArrayStack(capacity);
        this.s2 = new ArrayStack(capacity);
    }

    public boolean put(Object o){
        if(size==capacity){
            return false;
        }
        size++;
        return s1.push(o);
    }
    public Object take(){
        if(size==0){
            return null;
        }
        if(s2.size()>0){
            return s2.pop();
        }
        while (s1.size()>1){
            s2.push(s1.pop());
        }
        size--;
        return s1.pop();
    }

    public static void main(String[] args) {
        TwoStackQueue arrayQueue = new TwoStackQueue(3);
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
