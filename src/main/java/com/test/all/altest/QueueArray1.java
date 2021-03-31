package com.test.all.altest;

import java.util.Scanner;

public class QueueArray1 {
    public static void main(String[] args) {
        LoopQueue queue = new LoopQueue(5);
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        char input = ' ';
        while (loop) {
            System.out.println("e(exit):退出");
            System.out.println("a(add):添加元素到队尾");
            System.out.println("r(remove):移除元素从队头");
            System.out.println("s(show):显示队列");
            System.out.println("g(get):得到队头元素");
            input = scanner.next().charAt(0);
            switch (input) {
                case 'e':
                    loop = false;
                    break;
                case 'a':
                    System.out.println("请输入一个数字：");
                    queue.add(scanner.nextInt());
                    break;
                case 'r':
                    try {
                        int remove = queue.remove();
                        System.out.printf("出队的元素为：%d\n", remove);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    queue.showQueue();
                    break;
                case 'g':
                    try {
                        int head = queue.getHead();
                        System.out.println("队头元素为：" + head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
            }
        }
    }
}

class LoopQueue {    //循环队列
    private int front;
    private int rear;
    private int Size;
    private int[] arr;

    public LoopQueue(int Size) {
        this.Size = Size;
        front = rear = 0;
        arr = new int[Size];
    }

    public boolean isFull() {//判断队满
        return (rear + 1) % Size == front;
    }

    public boolean isEmpty() {//判断队空
        return rear == front;
    }

    public void add(int n) {//入队
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % Size;
    }

    public int remove() {//出队
        if (isEmpty()) {
            throw new RuntimeException("队列为空,没有元素可出队");
        }
        int n = arr[front];
        front = (front + 1) % Size;
        return n;
    }

    public int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有元素");
        }
        return arr[front];
    }

    public void showQueue() {//展示队列
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        //从front开始遍历，遍历多少个元素
        for (int i = front; i < front+size() ; i++) {
            System.out.printf("arr[%d]=%d ", i%Size, arr[i%Size]);
        }
        System.out.println();
    }

    //求出当前队列有效数据的个数
    public int size() {
        return (rear + Size - front) % Size;
    }


}
