package com.test.all.altest.off;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class YueCicle {
    public static void main(String[] args) {
        System.err.println(get(10,3));
        System.err.println(lastRemaining(10,3));
        int[] array = {1,3,4,2,5};
        quick(array,0,4);
        System.err.println(Arrays.toString(array));
        System.err.println(egg(5,3));
        System.err.println(superEggDrop(5,3));
    }
    // 1 2 3
    public static int get(int n ,int k ){
        List<Integer> list = new ArrayList<>();
        for(int i =0;i<n;i++){
            list.add(i);
        }
        int index =0;
        while (n>1){
            index = (index+k-1)%n;
            list.remove(index);
            n --;
        }
        return list.get(0);
    }
    public static int lastRemaining(int n, int m) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }

    public static void quick(int[] arr,int low,int high){
        if(low>=high){
           return;
        }
        int index = partition(arr,low,high);
        quick(arr,low,index-1);
        quick(arr,index+1,high);

    }
    public static int partition(int[] arr,int low,int high){
        int pivot =arr[low];
        int L=low;
        int R =high;
        while (L<R){
            while (L<R&&arr[R]>=pivot){
                R--;
            }
            arr[L] = arr[R];
            while (L<R&&arr[L]<=pivot){
                L++;
            }
            arr[R] = arr[L];

        }
        arr[L] =pivot;
        return L;
    }

    public static int egg(int N,int K){
        if(N==1){
            return 1;
        }
        if(K==1){
            return N;
        }
        int res =N;
        for(int i=1;i<=N;i++){
            res = Math.min(res,Math.max(egg(N-1,K-1),egg(N-1,K))+1);

        }
        return res;
    }

    public static int superEggDrop(int K, int N) {

        if(N==1) return 1;

        int[][] f=new int[N+1][K+1];
        for(int i=1;i<=K;i++) f[1][i]=1;

        int ans=-1;
        for(int i=2;i<=N;i++) {
            for(int j=1;j<=K;j++)
                f[i][j]=1+f[i-1][j-1]+f[i-1][j];
            if(f[i][K]>=N) {
                ans=i;
                break;
            }
        }
        return ans;

    }


}
