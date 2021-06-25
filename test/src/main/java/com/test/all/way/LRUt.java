package com.test.all.way;

import java.util.Map;
import java.util.Objects;

public class LRUt<K,V> {
    class Node<K,V>{
        K key;
        V value;
        Node<K,V> pre,next;
    }
    private int capacity;
    private int size;
    private Node head;
    private Node tail;
    private Map<K,Node> map;

    public void put(K k,V v){
        if(Objects.isNull(map.get(k))){
            if(size<capacity){
                Node node = new Node();
                head.next =node;

            }
        }

    }

    private void moveToHead(){

    }
    private void removeTail(){

    }
}
