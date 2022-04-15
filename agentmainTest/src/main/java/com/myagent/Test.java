package com.myagent;

public class Test {
    public int print(int i) {
        System.out.println("i: " + i);
        return i + 2;
    }

    public void run() {
        int i = 1;
        while (true) {
            i = print(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test main = new Test();
        main.run();
        Thread.sleep(1000 * 60 * 60);
    }
}
