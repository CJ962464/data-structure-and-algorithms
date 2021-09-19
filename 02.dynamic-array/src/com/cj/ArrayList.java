package com.cj;

/**
 * 模拟 JDK 数组集合数据结构
 *
 * @author cj
 */
public class ArrayList<E> {

    /**
     * 数组元素个数
     */
    private int size;

    /**
     * 存储所有元素的数组
     */
    private E[] elements;

    /**
     * 默认数组容量大小
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 数组中没有元素
     */
    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList(int capacity) {
        capacity = Math.max(capacity, DEFAULT_CAPACITY);
        elements = (E[]) new Object[capacity];
    }

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 清除所有元素
     */
    public void clear() {
        for (int i = 0; i < size; i++)
            elements[i] = null;

        size = 0;
    }

    /**
     * 元素的数量
     *
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 是否为空
     *
     * @return
     */
    public boolean isEmpty() {

        return size == 0;
    }

    /**
     * 是否包含某个元素
     *
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    /**
     * 添加元素到尾部
     *
     * @param element
     */
    public void add(E element) {
        add(size, element);
    }

    /**
     * 获取index位置的元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        rangeCheck(index);

        return elements[index];
    }

    /**
     * 设置index位置的元素
     *
     * @param index
     * @param element
     * @return 原来的元素ֵ
     */
    public E set(int index, E element) {
        rangeCheck(index);

        E oldValue = elements[index];
        elements[index] = element;

        return oldValue;
    }

    /**
     * 在index位置插入一个元素
     *
     * @param index
     * @param element
     */
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

    /**
     * 删除index位置的元素
     *
     * @param index
     * @return
     */
    public E remove(int index) {
        E oldValue = elements[index];

        // index 是要删除的元素, + 1 是把后面一个元素往前面挪动
        for (int i = index + 1; i < size; i++) {
            elements[i - 1] = elements[i];
        }

        elements[--size] = null;

        return oldValue;
    }

    /**
     * 查看元素的索引
     *
     * @param element
     * @return
     */
    public int indexOf(E element) {
        if (element == null) {  // 1
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (element.equals(elements[i])) return i; // n
            }
        }

        return ELEMENT_NOT_FOUND;
    }

    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Size = " + size + ", [");
        for (int i = 0; i < size; i++) {
            if (i != 0)
                sb.append(", ");

            sb.append(elements[i]);
        }

        return sb.toString();
    }
}
