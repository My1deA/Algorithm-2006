package com.example.demo.pass.leetcode.offer.string;

/*  把字符串转换成整数
写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。

首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；
假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
在任何情况下，若函数不能进行有效的转换时，请返回 0。

说明：
假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。

输入: "42"
输出: 42
示例 2:

输入: "   -42"
输出: -42
解释: 第一个非空白字符为 '-', 它是一个负号。
     我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。

输入: "4193 with words"
输出: 4193
解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。

输入: "words and 987"
输出: 0
解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     因此无法执行有效的转换。

输入: "-91283472332"
输出: -2147483648
解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     因此返回 INT_MIN (−231) 。
 */
class Solution67 {

    public int strToInt(String str) {
        char[] chars=str.trim().toCharArray();
        if(chars.length==0)return 0;
        int i=1,sign=1;
        if(chars[0]=='-'){
            sign=-1;
        }else if(chars[0] !='+') {
            i=0;
        }
        long res=0;
        for(int j=i;j<chars.length;j++){
            if(chars[j]<'0' || chars[j]>'9'){
                break;
            }
            res=res*10+chars[j]-'0';
            if(res>Integer.MAX_VALUE && sign==1){
                return Integer.MAX_VALUE;
            }else if(-res<Integer.MIN_VALUE && sign==-1){
                return Integer.MIN_VALUE;
            }
        }
        return  sign*(int)res;
    }

    public int strToInt2(String str) {
        Boolean flag=false;//开始记录
        StringBuffer stringBuffer=new StringBuffer();
        char ch;
        for(int i=0;i<str.length();i++){
            ch=str.charAt(i);
            //跳过空格
            if(ch== ' ' &&  !flag){
                continue;
            //字母 - 开始记录str
            }else if(((ch >= '0' && ch <= '9' )|| ch == '-' || ch== '+') && !flag){
                flag=true;
                //跳过+
                if(ch== '+'){
                    continue;
                }
                stringBuffer.append(ch);
            //记录 数字 字符
            }else if(flag && (ch >= '0' && ch <= '9' )){
                stringBuffer.append(ch);
            //如果不是 数字 - 开头 / 已经遍历完全 就break
            }else{
                break;
            }
        }
        //没有数字 || 只有 - 号
        if(stringBuffer.length()==0 || (stringBuffer.length()==1 && stringBuffer.toString().equals("-"))){
            return 0;
        } else{
            Long t=Long.valueOf(stringBuffer.toString());
            if(t<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else if(t>Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }
        }

        return Integer.valueOf(stringBuffer.toString());
    }
}

public class Title67 {
    public static void main(String[] args) {
        Solution67 solution67=new Solution67();
        System.out.println(solution67.strToInt("20000000000000000000"));
    }
}
