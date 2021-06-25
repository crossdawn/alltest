package com.test.all.altest;

public class StockTest {
    public static void main(String[] args) {
        int[] stock = {7, 6, 2, 5, 8, 1};
        System.err.println(most(stock));
    }

    private static int most(int[] stock) {
        int min = stock[0];
        int max = 0;
        for (int i = 1; i < stock.length ; i++) {
            if (stock[i] < min) {
                min = stock[i];
            }
            max = Math.max(max, stock[i] - min);
        }
        return max;
    }

}
