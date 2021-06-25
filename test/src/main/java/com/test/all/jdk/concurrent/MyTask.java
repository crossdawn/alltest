package com.test.all.jdk.concurrent;

public class MyTask implements Runnable {

    private String name;

    public MyTask(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.err.println("任务执行:"+name);
            Thread.sleep(6000_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MyTask{" +
                "name='" + name + '\'' +
                '}';
    }
}
