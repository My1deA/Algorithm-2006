package com.example.demo.cur.hottop;

import java.util.Scanner;

public class Hot1 {

    public static int[] twoSum(int[] nums, int target) {
        int [] ans=new int[2];
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {3,3};
        int target = 6;

        int[] ans=twoSum(nums,target);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }

    }

}

