package com.test.all.altest.tree;

import com.test.all.altest.link.ListNode;

public class MidT {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int a = area(grid, r, c);
                    res = Math.max(res, a);
                }
            }
        }
        return res;
    }

    public int majorityElement(int[] nums) {
        int a = nums[0];
        int count =1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==a){
                count++;
            }else if(--count ==0){
                a =nums[i];
                count = 1;
            }
        }
        return a;
    }



//10101001
//10101001
//10101001
    int area(int[][] grid, int r, int c) {
        if (!inArea(grid, r, c)) {
            return 0;
        }
        if (grid[r][c] != 1) {
            return 0;
        }
        grid[r][c] = 2;

        return 1
                + area(grid, r - 1, c)
                + area(grid, r + 1, c)
                + area(grid, r, c - 1)
                + area(grid, r, c + 1);
    }

    boolean inArea(int[][] grid, int r, int c) {
        return 0 <= r && r < grid.length
                && 0 <= c && c < grid[0].length;
    }

public int max(int[][] grids){
        int max =0;
        for(int r=0;r<grids.length;r++){
            for(int c =0;c<grids[0].length;c++){
                if(grids[r][c]==1){
                   int res = area(grids,r,c);
                   max = Math.max(max,res);
                }
            }
        }
        return max;
}

}
