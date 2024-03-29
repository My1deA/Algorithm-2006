package com.example.demo.pass.leetcode.offer.divide;

/*  面试题25. 合并两个排序的链表
输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

示例1：
输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

限制：
0 <= 链表长度 <= 1000

 */
class Solution25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), pre = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre.next = l1;
                pre = pre.next;
                l1 = l1.next;
            } else {
                pre.next = l2;
                pre = pre.next;
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            pre.next = l1;
        }
        if (l2 != null) {
            pre.next = l2;
        }

        return dummyHead.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null)return new ListNode(0);
        int flag=0;
        ListNode head=null;
        ListNode cur=null;
        while (l1!=null && l2!=null){
            ListNode node=null;
            if(l1.val > l2.val){
                node=new ListNode(l2.val);
                l2=l2.next;
            }else{
                node=new ListNode(l1.val);
                l1=l1.next;
            }
            if(flag == 0){
                head=node;
                cur=node;
                flag=1;
            }else{
                cur.next=node;
                cur=cur.next;
            }
        }

        while(l1!=null){
            ListNode node=new ListNode(l1.val);
            cur.next=node;
            cur=cur.next;
            l1=l1.next;
        }
        while (l2!=null){
            ListNode node=new ListNode(l2.val);
            cur.next=node;
            cur=cur.next;
            l2=l2.next;
        }
        return head;
    }
}


public class Title25 {
    public static void main(String[] args) {

    }
}