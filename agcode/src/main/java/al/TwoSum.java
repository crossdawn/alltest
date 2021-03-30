package al;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TwoSum {
    private int twoSum(int[] array,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<array.length-1;i++){
           if(Objects.nonNull(map.get(target-i))){
               return map.get(target-i);
           }
           map.put(target-i,i);
        }
       return -1;
    }
}
