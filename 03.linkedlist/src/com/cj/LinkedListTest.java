package com.cj;

/**
 * @program: data-structure-and-algorithms
 * @description: 链表测试
 * @author: C.J
 * @create: 2021/09/19
 **/
public class LinkedListTest {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(20);
        list.add(list.size(), 10);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(60);
        list.remove(3);

        System.out.println(list);
    }
}
