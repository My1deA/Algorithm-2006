package com.example.demo.pass.leetcode.top.part_4;

import java.util.HashMap;

public class T76_H {

    public String minWindow(String s, String t) {
        if (s.length()==0||t.length()>s.length()) return "";
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i <t.length(); i++) {
            char c=t.charAt(i);
            map.put(c,map.getOrDefault(c,0).intValue()+1);
        }
        int count=0;
        HashMap<Character,Integer> map1=new HashMap<>();
        int left =0,right=0,start=-1;

        int len=Integer.MAX_VALUE;
        while (right<s.length()){
            char tmp=s.charAt(right);
            right++;
            if (map.containsKey(tmp)){
                map1.put(tmp,map1.getOrDefault(tmp,0)+1);
                if (map.get(tmp).intValue()==map1.get(tmp).intValue()){
                    count++;
                }
            }

            while (count==map.size()){
                if (len>right-left){
                    len=right-left;
                    start=left;
                }
                char tmp1=s.charAt(left);
                if (map.containsKey(tmp1)){
                    if (map.get(tmp1).intValue()==map1.get(tmp1).intValue()){
                        count--;
                    }
                    map1.put(tmp1,map1.get(tmp1).intValue()-1);
                }
                left++;
            }
        }
        return len == Integer.MAX_VALUE ?
                "" : s.substring(start, start+len);
    }

}
