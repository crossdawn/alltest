package com.test.all.altest;

public class HannaTa {
    private static int i=0;
    public static void main(String[] args) {
        int n = 3;
        hn(n, "A", "B", "C");
    }

    private static void move(int n,String from,String to){
        System.err.println(++i+"移动"+n+"从"+from+"到"+to);
    }

    private static void hn(int n ,String a ,String b ,String c){
        if(n==1){
           move(n,a,c);
        }else {
            hn(n-1, a, c, b);
            move(n,a,c);
            hn(n-1, b, c, a);
        }
    }

    private static void  hn2(int n ,String a,String b ,String c){
        if(n==1){
            move(1,a,c);
            return ;
        }
        hn(n-1,a,c,b);
        move(n,a,c);
        hn(n-1,b,c,a);
    }
    //ABCAAABBCC
    public static int get(char[] chars,int free){
        int n = chars.length;
        int[] count = new int[26];
        int maxCount = 0;
        for(char c:chars){
            int num = count[c-'A'];
            if(num==0){
                count[c-'A']=1;
            }else{
                count[c-'A']=num+1;
            }
            maxCount = Math.max(count[c-'A'],maxCount);
        }
        int maxKinds =0;
        for(int i :count){
            if(i==maxCount){
                maxKinds++;
            }
        }
        //AB AB A;
        int temp =n-maxKinds;
        int spaceCunt = Math.max(0,free*(maxCount-1) -temp);
        return n+spaceCunt;
    }

}
