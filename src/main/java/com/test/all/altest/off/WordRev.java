package com.test.all.altest.off;

public class WordRev {
    public static void main(String[] args) {
        System.err.println(rev(" hello world "));
    }
    // hello world
    public static String rev(String s){
        String ns = s.trim();
        int i =ns.length()-1;
        int j =i;
        StringBuilder sb = new StringBuilder();
        while (i>=0){
            while (i>=0&&ns.charAt(i)!=' '){
                i--;
            }
            sb.append(ns.substring(i+1,j+1));
            while (i>=0&&ns.charAt(i)==' '){
                i--;
            }
            j=i;
        }
        return sb.toString();
    }
}
