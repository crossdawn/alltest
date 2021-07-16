package com.test.all.co;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

public class B {
    int i;
    Integer ii;
    Object o;

    public B(int i, Integer ii, Object o) {
        this.i = i;
        this.ii = ii;
        this.o = o;
    }

    public static void main(String[] args) throws Exception {
//        B  b= new B(1,1,"");
//        ClassLayout layout5 = ClassLayout.parseInstance(b);
//        System.err.println(layout5.toPrintable());
//        ClassLayout layout = ClassLayout.parseInstance("1");
//        System.err.println(layout.toPrintable());

        ClassLayout layout = ClassLayout.parseInstance(new StringT("1"));
        System.err.println(layout.toPrintable());
        int[] ints = new int[]{};
        StringT[] aa = new StringT[1];
        aa[0] = new StringT("");
        System.out.println(GraphLayout.parseInstance(aa).toPrintable());
        System.out.println(GraphLayout.parseInstance(aa).toFootprint());
    }
}
