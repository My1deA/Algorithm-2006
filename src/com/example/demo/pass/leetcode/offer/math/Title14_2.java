package com.example.demo.pass.leetcode.offer.math;

/*  面试题14- II. 剪绳子 II

给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。
请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36

提示 2 <= n <= 58
 */
public class Title14_2 {
    public static void main(String[] args) {
        Solution14_2 solution14_2=new Solution14_2();
        System.out.println(solution14_2.cuttingRope(127));
    }
}

class Solution14_2 {
    public int cuttingRope(int n) {
        if(n==1||n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        long sum=1;
        while(n>4){
            sum=sum*3%1000000007;
            n=n-3;
        }
        return (int)(sum*n%1000000007);
    }
}