package com.test.all.co;

import org.openjdk.jol.info.ClassData;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class A extends B{
        int i;
        Integer ii;
        Double d ;
        String s ="213123123123213";
        List<Integer> list = new ArrayList<>();

    public A() {
        super(1,1,1);
        this.i = 1;
        this.d = 1D;
        this.s = "23123";
        this.list = Arrays.asList(1,2,3,4,5);
    }


    public  void get(Object o){
        synchronized(o){
            try {
                System.err.println(Thread.currentThread().getId()+"sleep");
                Thread.sleep(50_000);
            }catch (Exception e){

            }
        }
    }

}
