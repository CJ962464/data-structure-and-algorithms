package com.cj.链表;

import com.sun.corba.se.impl.interceptors.SlotTable;

import javax.swing.plaf.SliderUI;

/**
 * @program: data-structure-and-algorithms
 * @description: https://leetcode-cn.com/problems/linked-list-cycle/
 * @author: C.J
 * @create: 2021/09/19
 **/
public class _141_环形链表 {

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) return false;

        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) return true;
            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
