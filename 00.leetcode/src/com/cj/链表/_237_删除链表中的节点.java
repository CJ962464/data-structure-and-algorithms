package com.cj.链表;

/**
 * @program: data-structure-and-algorithms
 * @description: https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @author: C.J
 * @create: 2021/09/19
 **/
public class _237_删除链表中的节点 {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
