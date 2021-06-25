package com.test.all.jdk.collection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {
    public static Map<String,String> orderMap(){

        /**
         * 实例化一个LinkedHashMap;
         *
         * LinkedHashMap的插入顺序和访问顺序;
         * LinkedHashMap(int initialCapacity, float loadFactor, boolean accessOrder);
         * 说明:
         * 	当accessOrder为true时表示当前数据的插入读取顺序为访问顺序；
         * 	当accessOrder为false时表示当前数据的插入读取顺序为插入顺序；
         */
        Map<String,String> linkedHashMap = new LinkedHashMap<String,String>(0,1.6f,false); // 访问顺序;
//		Map<String,String> linkedHashMap = new LinkedHashMap<String,String>(0,1.6f,false); // 插入顺序;

        // 数据插入;
        linkedHashMap.put("key_1", "value_11111");
        linkedHashMap.put("key_2", "value_22222");
        linkedHashMap.put("key_3", "value_33333");
        linkedHashMap.put("key_4", "value_44444");
        linkedHashMap.put("key_5", "value_55555");
        linkedHashMap.put("key_2", "value_55555");


        /**
         * 打印集合数据,看输出顺序是什么样子?
         * 首先获取Map对象的Entry对象集;
         * 然后遍历打印Entry对象;
         * 注意:此时是程序开始的第一次数据打印;
         */
        Set<Map.Entry<String,String>> entrySet = linkedHashMap.entrySet();
        for(Map.Entry<String,String> entry : entrySet){
            System.out.println("key:"+entry.getKey()+";  Value: "+entry.getValue());
        }

        // 在这里做一条两次打印的分界线;
        System.out.println("--------------------------------------------");

        // 最终我们把集合返回;
        return linkedHashMap;
    }

    /**
     * 程序的主入口
     * 我们把第一次的数据打印封装成一个接口来单独调用;
     * 然后再这里打印第二次调用元素之后的结果;
     */
    public static void main(String[] args) {

        /**
         * 在这里我们调用封装好的数据接口;
         * 接口中会提前把插入好的数据打印一次;
         * 然后我们在这里开始调用打印测试;
         */
        Map<String, String> orderMap = orderMap();

        // 首先随机调用数据中的一个元素;
        orderMap.get("key_3");
        orderMap.get("key_5");

        /**
         * 然后以同样的方式遍历打印Entry对象;
         * 注意:此时是程序开始的第二次数据打印;
         */
        Set<Map.Entry<String,String>> entrySet = orderMap.entrySet();
        for(Map.Entry<String,String> entry : entrySet){
            System.out.println("key:"+entry.getKey()+";  Value: "+entry.getValue());
        }
    }


}
