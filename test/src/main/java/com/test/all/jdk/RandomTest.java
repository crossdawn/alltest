package com.test.all.jdk;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        testRandom();
        System.out.println("---------------------");
        testRandom();
        System.out.println("---------------------");
        testRandom();
    }

    public static void testRandom(){
        Random random = new Random(1);
        for(int i=0; i<5; i++){
            System.out.print(random.nextInt()+"\t");
        }
        System.out.println("");
    }
}
