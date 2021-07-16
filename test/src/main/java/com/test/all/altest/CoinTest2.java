package com.test.all.altest;

public class CoinTest2 {

    private static int d(int[] array, int index, int rest) {
        int ways = 0;
        for (int i = 1; i * array[index] < rest; i++) {
            ways += d(array, index + 1, rest - i * array[index]);
        }
        return ways;
    }

    // arr中都是正数且无重复值，返回组成aim的方法数，暴力递归
    public static int ways1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    public static int process1(int[] arr, int index, int rest) {
        // base case
        // 当在面值数组的arr.length，此时越界，没有货币可以选择。
        // 如果当前目标金额就是0，那么存在一种方法，如果目标金额不为0，返回0中方法
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }

        // 普遍位置
        int ways = 0;
        // 从0号位置开始枚举，选择0张，1张，2张等
        // 条件是张数乘以选择的面值，不超过木匾面值rest
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            // 方法数加上除去当前选择后所剩面额到下一位置的选择数，递归
            ways += process1(arr, index + 1, rest - (zhang * arr[index]));
        }
        return ways;
    }

    private static int ways2(int[] arr,int index,int rest){
        if(index==arr.length){
            if(rest==0){
                return 1;
            }
            return 0;
        }
        int ways=0;
        for(int zhang=0;zhang*arr[index]<=rest;zhang++){
            ways+=ways2( arr,index+1, rest-zhang*arr[index]);
        }
        return ways;
    }

    public static int coin(int[] coins,int amount){
        int[] m =new int[amount+1];
        for(int i =0;i<amount;i++){
            int min = Integer.MAX_VALUE;
            for(int j =0;i<coins.length;j++){
                if(i-coins[j]>0&&m[i-coins[j]]<min){
                  min =m[i-coins[j]] +1;
                }
            }
            m[i] = min;
        }
        return m[amount]==Integer.MAX_VALUE?-1:m[amount];
    }


    // ways1暴力递归，改为记忆化搜索。ways2为记忆化搜索版本
    public static int ways2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        // 缓存结构，且只和index和rest有关，跟arr无关
        int[][] dp = new int[arr.length + 1][aim + 1];
        // 一开始所有的过程，都没有计算呢，dp二维表初始化为-1
        // dp[..][..]  = -1
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        // 缓存结构向下传递
        return process2(arr, 0, aim, dp);
    }

    // 如果index和rest的参数组合，是没算过的，dp[index][rest] == -1
    // 如果index和rest的参数组合，是算过的，dp[index][rest]  > - 1
    public static int process2(int[] arr,
                               int index, int rest,
                               int[][] dp) {
        if (dp[index][rest] != -1) {
            return dp[index][rest];
        }
        if (index == arr.length) {
            dp[index][rest] = rest == 0 ? 1 : 0;
            return dp[index][rest];
        }
        int ways = 0;
        for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
            // 返回之前加入缓存
            ways += process2(arr, index + 1, rest - (zhang * arr[index]), dp);
        }
        // 返回之前加入缓存
        dp[index][rest] = ways;
        return ways;
    }

    // 记忆化搜索改造为动态规划版本，ways3。
    // 如果没有枚举行为，该动态该规划为自顶向下的动态规划和记忆化搜索等效，但这题存在枚举行为。
    public static int ways3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        // dp表
        int[][] dp = new int[N + 1][aim + 1];
        // 根据递归方法，N为arr的越界位置，但是我们的dp表定义的是N+1。
        // N位置，如果aim为0，则dp[N][0] = 1;
        dp[N][0] = 1;// dp[N][1...aim] = 0;

        // 每个位置依赖自己下面的位置，那么我们从下往上循环
        for (int index = N - 1; index >= 0; index--) {
            // rest从左往右
            for (int rest = 0; rest <= aim; rest++) {
                int ways = 0;
                for (int zhang = 0; zhang * arr[index] <= rest; zhang++) {
                    ways += dp[index + 1][rest - (zhang * arr[index])];
                }
                dp[index][rest] = ways;
            }
        }
        // 最终我们需要[0,aim]位置的解
        return dp[0][aim];
    }

    // 由于存在枚举行为，我们可以进一步优化我们的动态规划。ways4是优化的动态规划
    // 根据枚举，用具体化例子来找出规律，省掉枚举
    public static int ways4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int N = arr.length;
        int[][] dp = new int[N + 1][aim + 1];
        dp[N][0] = 1;// dp[N][1...aim] = 0;
        for (int index = N - 1; index >= 0; index--) {
            for (int rest = 0; rest <= aim; rest++) {
                dp[index][rest] = dp[index + 1][rest];
                if (rest - arr[index] >= 0) {
                    dp[index][rest] += dp[index][rest - arr[index]];
                }
            }
        }
        return dp[0][aim];
    }

    public static int process5(int[] array, int index, int rest) {
        if (index == array.length) {
            return rest == 0 ? 1 : 0;
        }
        int ways = 0;
        for (int zhang = 0; zhang * array[index] <= rest; zhang++) {
            ways += process5(array, index + 1, rest - zhang * array[index]);
        }
        return ways;
    }

    public static int ways5(int[] array, int rest) {
        return process5(array, 0, rest);
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, 50, 100};
        int sum = 1000;
        System.out.println(ways1(arr, sum));
        System.out.println(ways2(arr, sum));
        System.out.println(ways3(arr, sum));
        System.out.println(ways4(arr, sum));
        System.out.println(ways5(arr, sum));
        Integer a =1;
        Short s =1;
//        Long l =1L;
        System.err.println(System.identityHashCode(a));
        System.err.println(System.identityHashCode(s));
//        System.err.println(System.identityHashCode(l));


    }
}
