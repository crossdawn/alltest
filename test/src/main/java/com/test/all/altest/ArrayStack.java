package com.test.all.altest;

public class ArrayStack {
    private Object[] array;
    private int capacity;
    private int size;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public boolean push(Object o) {
        if (size == capacity) {
            return false;
        }
        array[size++] = o;
        return true;
    }

    public int size() {
        return size;
    }

    public Object pop() {
        if (size == 0) {
            return null;
        }
        Object o = array[--size];
        return o;
    }

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
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
