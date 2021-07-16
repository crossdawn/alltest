package com.test.all.altest.array;

import jdk.internal.org.objectweb.asm.Handle;

import java.util.HashMap;
import java.util.Map;

public class MaxLength {
        public int lengthOfLongestSubstring1(String s) {
            Map<Character,Integer> map = new HashMap<>();
            int max =0;
            int left =0;
            //1233
            for(int i=0;i<s.length();i++){
                if(map.get(s.charAt(i))!=null){
                    left = Math.max(left,map.get(s.charAt(i))+1);
                }
                map.put(s.charAt(i),i);
                max =Math.max(max,i-left+1);
            }
            return max;
        }


}
