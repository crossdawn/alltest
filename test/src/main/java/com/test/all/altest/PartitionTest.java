package com.test.all.altest;

import java.util.*;

public class PartitionTest {
    public static void main(String[] args) {
        int[] array = {1,2, 7, 3, 2, 2};
//        int p = partition(array, 0, array.length - 1);
//        System.err.println(p);
//        System.err.println(Arrays.toString(array));
//        System.err.println(k(array, 2));
//        System.err.println(middle(array));
//        int[] range1 = partition333(array,0,array.length-1,2);
//        System.err.println(Arrays.toString(range1));
//        int[] array2 = {1,2, 7, 3, 2, 2};
//
//        int[] range = partition444(array2,0,array2.length-1,2);
//        System.err.println(Arrays.toString(range));
        System.err.println(lcseq("abcde","ace"));
    }

    public static int partition(int[] array, int l, int h) {
        int pivot = array[l];

        while (l < h) {
            while (l < h && pivot <= array[h]) {
                h--;
            }
            array[l] = array[h];
            while (l < h && pivot > array[l]) {
                l++;
            }
            array[h] = array[l];
        }
        array[l] = pivot;
        return l;
    }

    public static int k(int[] array, int k) {
        int index = partition(array, 0, array.length - 1);
        while (index != (k - 1)) {
            if (index > (k - 1)) {
                index = partition(array, 0, index - 1);
            } else {
                index = partition(array, index + 1, array.length - 1);
            }
        }
        return array[index];
    }

    public static int middle(int[] array) {
        int middle = array.length >> 1;
        int index = partition(array, 0, array.length - 1);
        while (index != middle) {
            if (index > (middle - 1)) {
                index = partition(array, 0, index - 1);
            } else {
                index = partition(array, index + 1, array.length - 1);
            }
        }
        int cnt = 0;
        for (int value : array) {
            if (array[index] == value) {
                cnt++;
            }
            if (cnt * 2 > array.length) {
                return array[index];
            }
        }
        return -1;
    }

    public static int[] partition333(int[] arr, int L, int R, int pivot) {
        int less = L - 1;
        int more = R + 1;
        int cur = L;
        while (cur < more) {
            if (arr[cur] < pivot) {
                swap(arr, ++less, cur);
                cur++;
            } else if (arr[cur] > pivot) {
                swap(arr, cur, --more);
            } else {
                cur++;
            }
        }
        System.err.println(Arrays.toString(arr));
        return new int[] { less + 1, more - 1 };
    }

    public static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    public static int[] partition444(int[] array,int L,int R,int pivot){
        int less= L-1;
        int more=R+1;
        int cur =L;
        while (cur<more){
            if(array[cur]<pivot){
                swap(array,cur,++less);
                cur++;
            }else if(array[cur]>pivot){
                swap(array,cur,--more);

            }else {
                cur++;
            }
        }
        System.err.println(Arrays.toString(array));
        return new int[]{less+1,more-1};
    }


    public static int lcs(String s1,String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int m = chars1.length;
        int n = chars2.length;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                  if(chars1[i]==chars1[j]){
                      dp[i+1][j+1] = dp[i][j]+1;
                  }else if(dp[i][j+1]>dp[i+1][j]){
                      dp[i+1][j+1]=dp[i][j+1];
                  }else {
                      dp[i+1][j+1]=dp[i+1][j];
                  }
            }
        }
        return 1;
    }

    public static int edict(String s1,String s2){
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int m =chars1.length;
        int n = chars2.length-1;
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<n;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(chars1[i-1]==chars2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
                dp[i][j] = Math.min(dp[i-1][j]+1,Math.min(dp[i][j-1]+1,dp[i-1][j-1]));
            }
        }
        return dp[m][n];
    }

    public static boolean isSubSeq(String s1,String s2){
        int i=0,j=0;
        while (i<s1.length()&&j<s2.length()){
            if(s1.charAt(i)==s2.charAt(j)){
                i++;
            }
            j++;
        }
        return i==s1.length();
    }

    public static int lcstr(String s1,String s2){
        int m =s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];
        for (int i=0;i<s1.length();i++){
            for (int j=0;j<s2.length();j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m-1][n];
    }

    public static int lcseq(String s1,String s2){
        int m =s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];
        if(s1.charAt(0)==s2.charAt(0)){
            dp[0][0] = 1;
        }
        for (int i=1;i<s1.length();i++){
            for (int j=1;j<s2.length();j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static boolean isValid(String str){
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(char c:chars){
            if('('==c){
                stack.push(')');
            }
            else if('['==c){
                stack.push(']');
            }
            else if('{'==c){
                stack.push('}');
            }else {
                if(c==stack.pop()||!stack.isEmpty()){
                    return false;
                }
            }
        }
        return true;

    }
//    public static int lcseq(String s1,String s2){
//        if(s1==null||s2==null){
//            return 0;
//        }
//        int m = s1.length();
//        int n = s2.length();
//        int[][] dp = new int[m][n];
//        dp[0][0] = s1.charAt(0)==s2.charAt(0)?1:0;
//        for(int i =0;i<m;i++){
//            dp[i][0]=s1.charAt(i)==s2.charAt(0)?1:dp[i-1][0];
//        }
//        for(int j =0;j<n;j++){
//            dp[0][j]=s1.charAt(0)==s2.charAt(j)?1:dp[0][j-1];
//        }
//        for(int i=1;i<m;i++){
//            for(int j=1;j<n;j++){
//                int p1=dp[i][j-1];
//                int p2=dp[i-1][j];
//                int p3=s1.charAt(i)==s2.charAt(i)?dp[i-1][j-1]:0;
//                dp[i][j] = Math.max(p1,Math.max(p2,p3));
//            }
//        }
//        return dp[m-1][n-1];
//    }

    public static int getM(int[] array,int L,int R) {
        int fisrt = f(array, L, R);
        int second = g(array, L, R);
        return Math.max(fisrt, second);
    }
    public static int  f(int[] array,int L,int R){
        if(L==R){
            return array[L];
        }
        int p1 = array[L]+g(array,L+1,R);
        int p2 =array[R] +g(array,L,R-1);
        return Math.max(p1,p2);
    }

    public static int g(int[] array,int L,int R){
        if(L==R){
            return 0;
        }
        int p1 =array[L]+ f(array,L+1,R);
        int p2 =array[R]+ f(array,L,R-1);
        return Math.min(p1,p2);
    }

    public static boolean can(int[] nums ,int k){
        int sum = 0;
        for(int i:nums){
            sum+=i;
        }
        int target =sum/k;
        int[] buckets = new int[k];

        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        for (; i < j; i++, j--) {
            // 交换 nums[i] 和 nums[j]
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        return can(nums,0,buckets,target);
    }

    public static boolean can(int[] nums ,int index,int[] buckets,int target){
        if(index==nums.length){
            for(int i:buckets){
                if(i!=target){
                    return false;
                }
            }
            return true;
        }
        for(int i=0;i<buckets.length;i++){
            if(buckets[i]+nums[index]>target){
                continue;
            }
            buckets[i]+=nums[index];
            if(can( nums , index+1,buckets, target)){
                return true;
            }
            buckets[i]-=nums[index];
        }
        return false;
    }

    public int findKthLargest(int[] nums, int k) {
        int a = new Random().nextInt(nums.length);
        int temp = nums[a];
        nums[a] = nums[0];
        nums[0] =temp;
        int index = partition1(nums,0,nums.length-1);
        int target = nums.length-k;
        while (true){
            if(index==target){
                return nums[index];
            }else if(index>target){
                partition1(nums,index+1,nums.length-1);
            }else {
                partition1(nums,0,index-1);
            }
        }
    }

    public int partition1(int[] nums, int low,int high) {
        int pivot =nums[low];
        int left  = low;
        int right =high;
        while (left<right){
            while (left<right&&nums[right]<=pivot){

                right--;
            }
            nums[left] =nums[right];

            while (left<right&&nums[left]>=pivot){
                left++;
            }
            nums[right] =nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] =grid[m-1][n-1];
        for(int i=0;i<m;i++){
            dp[i][0] = dp[i-1][0]+grid[i-1][0];
        }
        for(int j=0;j<n;j++){
            dp[m-1][j-1]= dp[m-1][j]+grid[m-1][j-1];
        }
        for(int i =m-1;i>=0;i--){
            for(int j =n-1;j>=0;j--){
                dp[i-1][j-1] = dp[i][j]+Math.min(grid[i-1][j],grid[i][j-1]);
            }
        }
        return dp[m-1][n-1];
    }

}
