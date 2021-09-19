package com.cj;

/**
 * @program: data-structure-and-algorithms
 * @description: 数据结构与算法之模拟 JDK List 集合
 * @author: C.J
 * @create: 2021/09/19
 **/
public class ArrayList<E> extends AbstractList<E> {

    /**
     * 存储所有元素的数组
     */
    private E[] elements;

    /**
     * 默认数组容量大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList(int capacity) {
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        elements = (E[]) new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++)
            elements[i] = null;

        size = 0;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);

        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);

        E oldValue = elements[index];
        elements[index] = element;

        return oldValue;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        ensureCapacity(size + 1);

        for (int i = size; i > index; i--)
            elements[i] = elements[i - 1];

        elements[index] = element;
        size++;
    }

    /**
     * 数组扩容到原数组的 1.5 倍大小
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if (oldCapacity >= capacity) return;
        // 1.5 倍大小
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        E[] newElements = (E[]) new Object[newCapacity];

        for (int i = 0; i < elements.length; i++)
            newElements[i] = elements[i];

        elements = newElements;

        System.out.println("oldCapacity: " + oldCapacity + " --> newCapacity:" + newCapacity);
    }

    @Override
    public E remove(int index) {
        E oldValue = elements[index];

        // index 是要删除的元素, + 1 是把后面一个元素往前面挪动
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }

        elements[--size] = null;

        return oldValue;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i;
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Size = " + size + ", [");
        for (int i = 0; i < size; i++) {
            if (i != 0)
                sb.append(", ");

            sb.append(elements[i]);
        }

        sb.append("]");

        return sb.toString();
    }
}
