package com.test.all.altest.tree;


import java.util.*;

public class MaxValue {
    //"abcabcbb"
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        LinkedList<Integer> list = new LinkedList<>();
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(set.contains(s.charAt(i))){
                int first =list.peekFirst();
                int last =list.peekLast();
                max = Math.max(max,last-first+1);
                int a=0;
                while (s.charAt(i)<=first){
                    list.removeFirst();
                    a++;
                }
                set.remove(s.charAt(i));
            }
            set.add(s.charAt(i));
            list.addLast(i);
        }
        return max;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character,Integer> map = new HashMap<>();
        LinkedList<Integer> list = new LinkedList<>();
        int max = 0;
        int left = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                left =Math.max(left,map.get(c)+1);
            }
            map.put(c,i);
            max = Math.max(max,i-left+1);
        }
        return max;
    }

    public int count(int[] nums) {
        int s = nums[0];
        int count =1;
        for(int i=0;i<nums.length;i++){
            if(nums[i] ==s){
                count++;
            }else {
                count--;
                if(count==0){
                    s = nums[i];
                    count=1;
                }
            }
        }
        return s;
    }


}
