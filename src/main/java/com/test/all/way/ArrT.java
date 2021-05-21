package com.test.all.way;

public class ArrT {
    public static void swap(int A[], int i, int j){
        if(A.length==0 || i<0 || j<0) return;

        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void printAll(int A[], int n){
        for (int i=0; i<n; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();
    }

    public static void perm(int A[], int p, int q){
        if(p == q){
            printAll(A, q+1);
        }else{
            int i;
            for(i=p; i<=q; i++){
                swap(A, p, i);
                perm(A, p+1, q);
                swap(A, p, i);
            }
        }
    }

    public static void main(String args[]){
        int A[] = {1, 2, 3, 4};
        a(A, 0, A.length-1);
    }

    public int majorityElement(int[] nums) {
        int len = nums.length;
        int result = nums[0];
        int count =0;
        for(int i =0;i<len;i++){
            if(result==nums[i]){
                count++;
            }else {
                count--;
                if(count==0){
                    result =nums[i];
                }
            }
        }
        return result;
    }

    /**
     * 全排列
     * @param array
     * @param p
     * @param q
     */
    public static void a(int[] array,int p,int q){
        if(p==q){
          printAll(array,q+1);
        }else {
            for(int i =p;i<=q;i++){
                swap(array,p,i);
                a(array,p+1,q);
                swap(array,p,i);
            }
        }
    }
}
