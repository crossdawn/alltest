package com.test.all.altest;

import com.test.all.way.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Heap {
    public static void main(String[] args) {
        int[] array = {5,3,2,4,1};
//        heapSort(array);
//        System.err.println(Arrays.toString(array));
        List<List<Integer>> list = permute(array);
        list.forEach(x-> System.err.println(Arrays.toString(x.toArray())));
    }
    //堆排序
    public static void heapSort(int[] arr) {
        //构造大根堆
        heapInsert(arr);
        int size = arr.length;
        while (size > 1) {
            //固定最大值
            swap(arr, 0, size - 1);
            size--;
            //构造大根堆
            heapify(arr, 0, size);
        }

    }

    //构造大根堆（通过新插入的数上升）
    public static void heapInsert(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //当前插入的索引
            int currentIndex = i;
            //父结点索引
            int fatherIndex = (currentIndex - 1) / 2;
            //如果当前插入的值大于其父结点的值,则交换值，并且将索引指向父结点
            //然后继续和上面的父结点值比较，直到不大于父结点，则退出循环
            while (arr[currentIndex] > arr[fatherIndex]) {
                //交换当前结点与父结点的值
                swap(arr, currentIndex, fatherIndex);
                //将当前索引指向父索引
                currentIndex = fatherIndex;
                //重新计算当前索引的父索引
                fatherIndex = (currentIndex - 1) / 2;
            }
        }
    }
    public static void heapInsert1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int cur = i;
            int father = (i-1)/2;
            while (arr[cur]>arr[father]){
                cur =father;
                father =(cur-1)/2;
            }
        }
    }
    //将剩余的数构造成大根堆（通过顶端的数下降）
    public static void heapify(int[] arr, int index, int size) {
        int left = 1;
        int right =2;
        while (left < size) {
            int largestIndex;
            //判断孩子中较大的值的索引（要确保右孩子在size范围之内）
            if (arr[left] < arr[right] && right < size) {
                largestIndex = right;
            } else {
                largestIndex = left;
            }
            //比较父结点的值与孩子中较大的值，并确定最大值的索引
            if (arr[index] > arr[largestIndex]) {
                largestIndex = index;
            }
            //如果父结点索引是最大值的索引，那已经是大根堆了，则退出循环
            if (index == largestIndex) {
                break;
            }
            //父结点不是最大值，与孩子中较大的值交换
            swap(arr, largestIndex, index);
            //将索引指向孩子中较大的值的索引
            index = largestIndex;
            //重新计算交换之后的孩子的索引
            left = 2 * index + 1;
            right = 2 * index + 2;
        }

    }
    //交换数组中两个元素的值
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void heapInsert12(int[] array){

        for(int i=0;i<array.length;i++){
            int cur =i;
            int father =(i-1)/2;
            while (array[cur]<array[father]){
                swap(array,cur,father);
                cur = father;
                father =(cur-1)/2;
            }
        }

    }
    public void sort(int[] array){
        heapInsert(array);
        int size =array.length;
        while (size>1){
            swap(array,0,array.length-1);
            size--;
            heapify(array,0,size);
        }
    }
    public void heapfy(int[] array,int size){
        int index =0;
        int left =1;
        int right =2;
        while (left<size){
            int largest = 0;
            if(array[left]>array[right]&& right < size){
                largest= left;
            }else {
                largest=right;
            }
            if(array[index]>array[largest]){
                largest = index;

            }

            if (index == largest) {
                break;
            }
            swap(array,largest,index);
            left = 2*index+1;
            right = 2*index+12;
        }

    }


    public void as(int[] nums){
        int left =0;
        int right = nums.length-1;
        while (left<right){
            while (left<right&&nums[left]/2==1){
                left++;
            }
            while (left<right&&nums[left]/2==0){
                right++;
            }
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] =temp;
        }
    }

    public int fastPow(int a,int n){
        int ans = 1;
        int base = a;
        while (n!=0){
            if((a&n)!=0){
                ans = ans*base;
            }
            n=n>>1;
            base =base*base;
        }
        return ans;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        process(nums,0,used,new ArrayList<>(),result);
        return result;
    }

    public static void process(int[] nums,int index,boolean[] used,List<Integer> path,List<List<Integer>> result) {
        if(index==nums.length){
            result.add(new ArrayList<>(path));
            return ;
        }
        for(int i=0;i<nums.length;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i]=true;
                process(nums,index+1,used,path,result);
                path.remove(path.size()-1);
                used[i]=false;
            }
        }
    }


}
