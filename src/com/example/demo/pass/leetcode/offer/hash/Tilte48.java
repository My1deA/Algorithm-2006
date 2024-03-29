package com.example.demo.pass.leetcode.offer.hash;

import java.util.HashMap;
import java.util.Map;

/* 面试题48. 最长不含重复字符的子字符串
请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

示例 1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。

示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 
提示：s.length <= 40000

 */
class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map=new HashMap<>();
        int i=-1,res=0;
        for(int j=0;j<s.length();j++){
            if(map.containsKey(s.charAt(j))){
                i=Math.max(i,map.get(s.charAt(j)));//前一个值的下标
            }
            map.put(s.charAt(j),j);//更新最新值
            res=Math.max(res,j-i);//求得和前一个相同值的 下标
        }
        return res;
    }
}

public class Tilte48 {
    public static void main(String[] args) {
        Solution48 solution48=new Solution48();

    }
}




















