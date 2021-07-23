package com.test.all.jdk.collection;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(Comparator.comparingInt(o -> -o));
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(3);
        treeSet.forEach(x-> System.err.println(x));
    }
}
