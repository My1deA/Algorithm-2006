package com.example.demo.pass.leetcode.offer.math;

/* 面试题17. 打印从1到最大的n位数
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]
 
说明：
用返回一个整数列表来代替打印
n 为正整数
 */
public class Title17 {
}

class Solution17 {
    public int[] printNumbers(int n) {
        if(n==0) return new int[0];
        int m=(int) Math.pow(10,n);
        int[] ans=new int[m-1];
        for(int i=0;i<m-1;i++){
            ans[i]=i+1;
        }
        return ans;
    }
}