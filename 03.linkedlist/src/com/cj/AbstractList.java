package com.cj;

/**
 * @program: data-structure-and-algorithms
 * @description: 抽取 List 和 LinkedList 的公共方法
 * @author: C.J
 * @create: 2021/09/19
 **/
public abstract class AbstractList<E> implements List<E> {
    /**
     * 元素个数
     */
    public int size;

    /**
     * 元素的数量
     *
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {

        return size == 0;
    }

    /**
     * 是否包含某个元素
     *
     * @param element
     */
    @Override
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到尾部
     *
     * @param element
     */
    @Override
    public void add(E element) {
        add(size, element);
    }

    protected void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    protected void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }


}
