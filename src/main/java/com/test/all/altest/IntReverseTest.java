package com.test.all.altest;

public class IntReverseTest {
    public static void main(String[] args) {
        System.err.println(rev(-23));
    }
    public static int rev(int x){
        int result =0;
        while (x!=0){
            result = result*10+x%10;
            x=x/10;
        }
        return result;
    }
}
