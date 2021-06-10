package com.test.all.netty;

public class Zixulie {
    public static int f(String x, String y)
    {
        if(x.length()==0) return 0;
        if(y.length()==0) return 0;

        String x1 = x.substring(1);
        String y1 = y.substring(1);

        if(x.charAt(0)==y.charAt(0)) return f(x1,y1)+1;

        return Math.max(f(x, y1),f(x1, y));
    }

    public static void main(String[] args)
    {
//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
//        ListNode listNode6 = new ListNode(6);
//
//        listNode1.next=listNode2;
//        listNode2.next=listNode3;
//        listNode3.next=listNode4;
//        listNode4.next=listNode5;
//        listNode5.next=listNode6;
//
//
//        ListNode head = rev(listNode1,2,4);
//        while (head!=null){
//            System.err.println(head.value);
//            head =head.next;
//        }
//        System.out.println(f("ac","abcd")); //2
//        System.out.println(f("acebbcde1133","xya33bc11de")); //5
        System.err.println(lcstr("1234","123"));
        System.err.println(findLongestCommonSubstring("1234","123"));

        System.err.println(findLongestCommonSubstring0("1234","123"));
    }

    public static int findLCS(String A, int n, String B, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i - 1][j] > dp[i][j - 1] ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }

    /**
     * 找出两个字符串的最长公共子串
     * 本方法采用的是遍历的方式，时间复杂度是O(n^3)。
     * 时间有点长啊！
     * @param string0
     * @param string1
     * @return
     */
    static public String findLongestCommonSubstring(String string0,String string1) {
        StringBuilder maxSubstring = new StringBuilder();
        for (int counter = 0;counter < string0.length();counter++) {
            for (int counter0 = 0;counter0 < string1.length();counter0++) {
                int pointer0 = counter;
                int pointer1 = counter0;
                int commonSubstringLength = 0;
                while (pointer0 < string0.length()
                        && pointer1 < string1.length()
                        && string0.charAt(pointer0) == string1.charAt(pointer1)) {
                    commonSubstringLength++;
                    if (commonSubstringLength > maxSubstring.length()) {
                        maxSubstring.delete(0,maxSubstring.length());
                        maxSubstring.append(string0.substring(counter,pointer0 + 1));
                    }
                    pointer0++;
                    pointer1++;
                }
            }
        }
        return maxSubstring.toString();
    }

    /**
     * 所谓动态规划思想就是认为大问题可以被拆分成小问题。
     * 它一般有3个性质:
     * 1、无论是总问题还是子问题都存在最优解。
     * 2、某问题只取决于它的子问题，和由它组成的问题没关系。
     * 3、各子问题之间大多是相互关联的。
     * 它每一阶段都有各个子问题的最优解，各子问题的最优解
     * 会产生往往会重复计算，于是用一个表把它们存储起来。
     * 具体到本问题就是每一个字符的相同，然后逐步到原来
     * 问题的解。
     * 本问题的解是两个字符串的最长公共子串，那么它的子
     * 问题的解的极限是1个字符是否相同。
     * 在解集中每个单元格的左上角的单元格就是前面相邻的两
     * 个字符是否相同。并且如果该单元格对应的下标不同，那
     * 么单元格可以立刻被置0.否则它就应该加上左上角的单元
     * 格中的解的值。
     * 应用动态规划算法以后时间复杂度变成了O(n^2)。
     * @param string0
     * @param string1
     * @return
     */
    static public String findLongestCommonSubstring0(String string0, String string1) {
        int[][] answerArray = new int[string0.length()][string1.length()];
        int maxSubstringLength = 0;
        int startLongestIndex = 0;
        for (int counter = 0; counter < string0.length(); counter++) {
            for (int counter0 = 0; counter0 < string1.length(); counter0++) {
                if (string0.charAt(counter) == string1.charAt(counter0)) {
                    if (counter - 1 >= 0 && counter0 - 1 >= 0) {
                        answerArray[counter][counter0] = answerArray[counter - 1][counter0 - 1] + 1;
                    } else {
                        answerArray[counter][counter0] = 1;
                    }

                    if (answerArray[counter][counter0] > maxSubstringLength) {
                        maxSubstringLength = answerArray[counter][counter0];
                        startLongestIndex = counter - maxSubstringLength + 1;
                    }
                } else {
                    answerArray[counter][counter0] = 0;
                }
            }
        }
        return string0.substring(startLongestIndex, startLongestIndex + maxSubstringLength);
    }


    public static int sub(String a,int alen,String b ,int blen){
        int[][] dp = new int[alen+1][blen+1];
        for (int i=1;i<alen;i++){
            for (int j=1;j<alen;j++){
                    if(a.charAt(i-1)==b.charAt(j-1)){
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }else {
//                        dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                        dp[i][j] =0;
                    }
            }
        }
        return dp[alen][blen];
    }

    ListNode reverseBetween(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween(head.next, m - 1, n - 1);
        return head;
    }
    ListNode successor = null; // 后驱节点

    // 反转以 head 为起点的 n 个节点，返回新的头结点
    ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = successor;
        return last;
    }
    //1-2-3-4-5
    private static ListNode rev(ListNode head,int m ,int n){

        ListNode pre =head;
        for(int i = 1;i<m;i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        while (m<n){
            ListNode temp =cur.next;
            cur.next = pre;
            pre =cur;
            cur = temp;
            m++;
        }
//        pre.next=pre;
        return head;
    }
    public static void intervalReverse(ListNode nodeLeft, ListNode nodeRight) {
        if(nodeLeft == nodeRight) {
            return;
        }else{
            ListNode last = nodeLeft.next;
            ListNode cur = last.next;
            while(cur != nodeRight) {
                last.next = cur.next;
                cur.next = nodeLeft.next;
                nodeLeft.next = cur;
                cur = last.next;
            }
        }
    }
    public static String lcstr(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];
        int maxStart = 0;
        int maxLength =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    if(i>0&&j>0){
                        dp[i][j] = dp[i-1][j-1] +1;
                    }else {
                        dp[i][j]=1;
                    }
                    if(maxLength<dp[i][j]){
                        maxLength = dp[i][j];
                        maxStart = i-maxLength+1;
                    }
                }else {
                    dp[i][j] = 0;
                }
            }
        }
        return s1.substring(maxStart,maxStart+maxLength);
    }

    public static String lcseq(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];
        int maxStart = 0;
        int maxLength =0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i+1][j+1] =dp[i][j]+1;
                }else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return s1.substring(maxStart,maxStart+maxLength);
    }

    public static int ed(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(s1.charAt(i)==s2.charAt(j)){
                    dp[i+1][j+1] =dp[i][j];
                }else {
                    dp[i+1][j+1] = Math.min(dp[i+1][j]+1,Math.min(dp[i][j+1]+1,dp[i][j]+1));
                }
            }
        }
        return dp[m][n];
    }

    public static void quick(int[] array,int low ,int high){
        int index = partition(array,low,high);
        quick(array,low ,index-1);
        quick(array,index+1 ,high);

    }

    public static int partition(int[] array,int low,int high){
        int pivot =array[0];
        int L= low;
        int R = high;
        while (L<=R){
            while (L<=R&&array[L]<pivot){
                L++;
            }
            array[L] =pivot;
            while (L<=R&&array[R]>pivot){
                R--;
            }
            array[R] =pivot;
            array[L] = pivot;
        }
        return L;
    }

}
