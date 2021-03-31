package com.test.all.altest;

/**
 * 数组实现队列
 * 循环数组
 */
public class MyArrayQueue  {
    private Object[] array;
    private int front;
    private int behind;
    private int size;
    private int capacity;

    public MyArrayQueue(int capacity){
        this.array = new Object[capacity];
        this.capacity=capacity;
    }

    public boolean isEmpty(){
        return size==capacity;
    }

    public boolean enqueue(Object o){
        if(size==capacity){
          return false;
        }
        array[behind]=o;
        size++;
        behind=(behind+1)%capacity;
        return true;
    }

    public Object dequeue(){
        if(size==0){
            return null;
        }
        Object o = array[front];
        size--;
        front=(front+1)%capacity;
        return o;
    }

    public static void main(String[] args) {
        MyArrayQueue myArrayQueue = new MyArrayQueue(4);

        System.out.println(myArrayQueue.enqueue("1"));
        System.out.println(myArrayQueue.enqueue("2"));
        System.out.println(myArrayQueue.enqueue("3"));
        System.out.println(myArrayQueue.enqueue("4"));
        System.out.println(myArrayQueue.dequeue());
        System.out.println(myArrayQueue.enqueue("4"));
        for(int i=0;i<4;i++){
            System.err.println(myArrayQueue.dequeue());
        }
    }

}
