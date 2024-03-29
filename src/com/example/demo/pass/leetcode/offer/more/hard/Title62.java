package com.example.demo.pass.leetcode.offer.more.hard;


import java.util.ArrayList;

/* 剑指 Offer 62. 圆圈中最后剩下的数字
0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。

输入: n = 5, m = 3
输出: 3
 */
class Solution62 {
    public int lastRemaining(int n, int m) {
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int i=0;
        while(n>1){
            i=(i+m-1)%n;
            list.remove(i);
            n--;
        }
        return list.get(0);
    }

    public int lastRemaining2(int n, int m) {
        int ans = 0;
        // 最后一轮剩下2个人，所以从2开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}

public class Title62 {
    public static void main(String[] args) {
        Solution62 solution62=new Solution62();
        System.out.println(solution62.lastRemaining(5,3));
    }
}
