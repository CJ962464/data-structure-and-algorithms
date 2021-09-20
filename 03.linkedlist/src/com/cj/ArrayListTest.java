package com.cj;

/**
 * @program: data-structure-and-algorithms
 * @description: 数组缩容测试
 * @author: C.J
 * @create: 2021/09/21
 **/
public class ArrayListTest {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList2<>();

        for (int i = 0; i < 50; i++) {
            ints.add(i);
        }

        for (int i = 0; i < 50; i++) {
            ints.remove(0);
        }
    }
}
