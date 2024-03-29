package com.example.demo.pass.algorithm.recursion;


// 9714 圣诞礼物  recursion
/*Description
        圣诞节到了，圣诞老人给 N 个小朋友准备了 M 个同样的礼物。每个小朋友有一个袜子（袜子不编号，无区别，认为袜子都相同），圣诞老人将 M 个礼物装到 N 个袜子中的放法有多少种？

        注意：
        1）若M=7 N=3，那么5,1,1的放法和1,5,1的放法算是同一种装法。
        2）允许袜子为空。
        3）M和N无大小关系，M可以比N大，M也可以比N小。

        Input
        输入数据包含两个整数 M,N。1<=M,N<=50。
        M在前，N在后，中间空格。

        Output
        输出共有几种不同的放法。

        Sample Input            Sample Output
        7 3                     8

        解法一:按书上算法求"对正整数n进行划分，最大加数不超过m的划分个数",因为此题"对正整数n进行划分，不超过m项的划分个数"与之是相等的.

        解法二:设d[i][j]表示i划分为j份，视为i个球放入j个盒子的方法数。盒子是无差别的。有如下递推关系：

        （1）j个盒子有空的，d[i][j] = d[i][j-1]，把某一空盒子拿出来放一边；
        （2）j个盒子都不空，d[i][j] = d[i-j][j]，每个盒子扣掉1个球；
        （3）d[i][0]=0,i>=1； d[i][1]=1,i>=1； d[0][j]=1, j>=1
        因此：d[i][j] = d[i][j-1]+ d[i-j][j]。  n划分为m份的划分数为d[n][m]。*/

public class T_9714 {

    public static int put(int i,int j){
        // 没有礼物 或者 没人分
        if(i < 1 || j < 1){
            return 0;
        }
        // 只有一个礼物 或者 只有一个人分
        if(i==1 || j==1){
            return 1;
        }
        // 礼物 比 人少 (允许礼物为空)
        if(i<j){
            return put(i,i);
        }
        //礼物每人一个 + 少一个人的礼物分总数
        if(i==j){
            return put(i,j-1)+1;
        }
        //少一个人的礼物分总数 + 每个人都拿一份
        return put(i,j-1)+put(i-j,j);

    }

    public static void main(String[] args) {
        int n=7,m=3;
        System.out.println(put(n,m));

    }
}
