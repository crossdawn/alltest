package com.test.all.altest.huiwen;

public class MaxLength {
    public static void main(String[] args) {
        System.err.println(9&1);
        System.err.println(1>>1);
        System.err.println(power(3,4));
    }

    public static long power(long a,int n){
        long weght = 1;

        while(n!=0){
            // n&1 等价于  n%2
            if((n&1)==1)weght *= a;
            a *= a;
            // n >>= 1 等价于  n = n/2;
            n >>=1;
        }
        return weght;
    }

    public static int q(int a ,int k){
        int ans =1;
        while (k>0){
            if((k&1) == 1){
                ans*=a;
            }
            a*=a;
            k>>=1;
        }
        return ans;
    }

    public String longestPalindrome(String s) {

        int n = s.length();
        int left = 0, right = 0, Length = 1, maxLength = 0;
        int maxBegin = 0, maxEnd = 0;

        for (int i=0;i<n;i++) {
            // 22332
            left = i - 1;
            right = i + 1;
            //看当前元素是否与其相邻的右侧元素相同
            while (right < n && s.charAt(i) == s.charAt(right)) {

                right++;
                Length++;
            }
            //看当前元素是否与其相邻的左侧元素相同(判断完右侧可以再判断左侧)
            while (left >= 0 && s.charAt(left) == s.charAt(i)) {

                left--;
                Length++;
            }
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {

                left--;
                right++;
                Length += 2;
            }
            if (Length > maxLength) {

                maxBegin = left + 1;//此时left指针指向的元素并不满足要求，应回移一位
                maxEnd = right - 1;//right指针指向的元素不满足要求，应回移一位
                maxLength = Length;
            }
            Length = 1;
        }
        //substring方法返回从指定的maxBegin处开始，一直到索引maxEnd - 1处的字符，所以 + 1
        return s.substring(maxBegin, maxEnd + 1);
    }

    public int getMax(int[] nums){
        int pre =nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            pre = Math.max(nums[i],nums[i]+pre);
            max = Math.max(max,pre);
        }
        return max;
    }
}
