package com.test.all.altest;

public class ArrayTest {
    public static void main(String[] args) {
//        Map<Integer,Integer> hash = new HashMap<>();
//        hash.put(1,2);
//        int[] a = {0,1,2,2,3};
//        Lock lock = new ReentrantLock();
//        lock.lock();
//        System.err.println(redu(a));
        System.err.println(add("999","0"));
        System.err.println(multiply("128","2"));
    }

    private static String add2(String num1,String num2){
        StringBuilder sb  = new StringBuilder();
        int carry=0;
        for(int i=num1.length()-1,j=num2.length()-1;i>=0||j>=0|carry>0;i--,j--){
            int a = i>=0?num1.charAt(i)-'0':0;
            int b = j>=0?num1.charAt(j)-'0':0;
            int sum =(a+b+carry)%10;
            sb.append(sum);
            carry=(a+b)/10;
        }
        return sb.reverse().toString();
    }
    private static String add(String num1,String num2){
        StringBuilder sb = new StringBuilder();
        int carry =0;
        for(int i = num1.length()-1,j=num2.length()-1; i>=0|| j>=0|carry>0;i--,j--){
            int a = i>=0?num1.charAt(i)-'0':0;
            int b = j>=0?num2.charAt(j)-'0':0;
            int sum = (a+b+carry)%10;
            sb.append(sum);
            carry =(a+b)/10;
        }
        return sb.reverse().toString();
    }

    public static String multiply(String num1, String num2) {
        String res ="0";
        for(int i=num2.length()-1;i>=0;i--){
            StringBuilder sb =new StringBuilder();
            int n2 = num2.charAt(i)-'0';
            int carry =0;
            for(int j=num1.length()-1;j>=0||carry>0;j--){
                int n1 = num1.charAt(j)-'0';
                int temp = (n2*n1+carry)%10;
                sb.append(temp);
                carry = (n2*n1+carry)/10;
            }
            res = add(res,sb.reverse().toString());
        }
        return res;
    }


    private static int rem(int[] array){
        int i =0;
        for(int j=1;j<array.length;j++){
            if(array[i]!=array[j]){
                i++;
                array[i]=array[j];
            }
        }
        return i+1;
    }

    private static int redu(int[] array){
        for(int i =0;i<array.length;i++){
            while (array[i]!=i){
                if(array[i]==array[array[i]]){
                    return array[i];
                }
                swap(array,i,array[i]);
            }
        }
        return -1;
    }

    private static void swap(int[] array,int i, int j) {
        int temp = array[i];
        array[i] =array[j];
        array[j] =temp;
    }
}
