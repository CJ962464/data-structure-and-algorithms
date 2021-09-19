package com.cj;

import sun.text.normalizer.CharTrie;

/**
 * @program: data-structure-and-algorithms
 * @description: 数据结构与算法之链表实现
 * @author: C.J
 * @create: 2021/09/19
 **/
public class LinkedList<E> extends AbstractList<E> {

    /**
     * 元素存储
     */
    private Node<E> first;
    private Node<E> node;

    private static class Node<E> {
        E element;

        Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {
        size = 0;
        first = null;
    }

    @Override
    public E get(int index) {

        return node(index).element;
    }

    /**
     * 根据传递的索引返回该索引指定的 node 节点
     *
     * @param index
     * @return
     */
    private Node<E> node(int index) {
        rangeCheck(index);

        Node<E> node = first;

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = node(index);
        E oldValue = node.element;
        node.element = element;

        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        if (index == 0) {
            first = new Node<>(element, first);
        } else {
            Node<E> prev = node(index - 1);
            prev.next = new Node<>(element, prev.next);
        }

        size++;
    }

    @Override
    public E remove(int index) {

        Node<E> node = first;
        if (index == 0) {
            first = first.next;
        } else {
            Node<E> prev = node(index - 1);
            node = prev.next;
            prev.next = node.next;
        }

        size--;

        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;

        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (node.element == null) return i;

                node = node.next;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(node.element)) return i;

                node = node.next;
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Size = " + size + ", [");
        Node<E> node = first;
        for (int i = 0; i < size; i++) {
            if (i != 0)
                sb.append(", ");

            sb.append(node.element);
            node = node.next;
        }

        sb.append("]");

        return sb.toString();
    }
}
