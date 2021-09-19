package com.cj.链表;

import sun.awt.ScrollPaneWheelScroller;

import java.time.temporal.Temporal;
import java.util.WeakHashMap;

/**
 * @program: data-structure-and-algorithms
 * @description: https://leetcode-cn.com/problems/reverse-linked-list/
 * @author: C.J
 * @create: 2021/09/19
 **/
public class _206_反转链表 {


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);

        // head.next = 4 -> 4.next =
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public ListNode reverseList1(ListNode head) {

       ListNode newHead = null;

       while (head != null) {
           ListNode tmp = head.next;
           head.next = newHead;
           newHead = head;
           head = tmp;
       }

       return newHead;
    }
}
