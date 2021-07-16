package com.test.all.altest.link;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubRev {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        //1 2 3 4 5
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    public ListNode rev(ListNode head,int left,int right){
        ListNode tem =  new ListNode(-1);
        tem.next =head;
        ListNode pre = tem;
        for (int i=0;i<left-1;i++){
            pre = pre.next;
        }
        ListNode cur =pre.next;
        ListNode next =null;
        for(int i=0;i<right-left;i++){
            next =cur.next;
            cur.next =next.next;
            next.next =pre.next;
            pre.next =next;
        }
        return tem.next;
    }

    public int maxProfit(int[] prices) {
        int min =prices[0];
        int profit = 0;
        for(int i=0;i<prices.length;i++){
           if(prices[i]<min){
               min =prices[i];
           }
            profit =Math.max(profit,prices[i]-min);
        }
        return profit;
    }
    //1 2 3 4 5 4321
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse2(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse2(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    public void nextPe(int[] nums){
        int i = nums.length-2;
        while (i>=0&&nums[i]>nums[i+1]){
          i--;
        }
        if(i>0){
            int j = nums.length - 1;
            while ( j>=0&&nums[j]<=nums[i]){
                i--;
            }
            swap(nums,i,j);
        }
    }

    public void swap2(int[] nums ,int i,int j){
        int temp =nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums ,int start){
        int left =start;
        int right = nums.length-1;
        while (left<left){
            swap(nums,start++,left--);
        }
    }
    //
    public List<String> letterCombinations2(String digits) {
        int[][] nums = {};
        return null;
    }
    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
    public void track(String digits, List<String> combinations,Map<Character,String> phoneMap,int index,StringBuilder sb){
        if(index==digits.length()){
            combinations.add(sb.toString());
        }else {
            char x =digits.charAt(index);
            String letters = phoneMap.get(x);
            for(int i=0;i<letters.length();i++){
                sb.append(letters.charAt(i));
                sb.deleteCharAt(index);
            }
        }
    }

}
