package com.example.demo.pass.leetcode.top.part_1;

import com.example.demo.pass.leetcode.top.common.ListNode;

/*
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。


示例：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4
 */
public class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(0);
        ListNode cur=head;
        while(l1!=null && l2!=null){
            ListNode node=null;
            if(l1.val<= l2.val){
                node=new ListNode(l1.val);
                l1=l1.next;
            }else{
                node=new ListNode(l2.val);
                l2=l2.next;
            }
            cur.next=node;
            cur=cur.next;
        }

        while(l1!=null){
            cur.next=new ListNode(l1.val);
            l1=l1.next;
            cur=cur.next;
        }

        while(l2!=null){
            cur.next=new ListNode(l2.val);
            l2=l2.next;
            cur=cur.next;
        }

        return head.next;
    }
}
