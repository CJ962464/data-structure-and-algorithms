package com.cj;

import com.sun.jndi.toolkit.ctx.StringHeadTail;

import java.util.concurrent.TimeUnit;

/**
 * 斐波那契数列: 求 n 的值就是 n 前第一个数 + n 前第二个数
 * 1 2 3 4 5 6 7 --> num = 7, 但是需要循环六次计算完
 * 0 1 1 2 3 5 8
 *
 * @author cj
 */
public class FibonacciSequence {

    /**
     * 递归方式实现斐波那契数列, 但是这种方式有性能问题, 随着传递进来的数据值越大就越慢
     */
    public static int fib1(int num) {
        // 添加边界值, 否则死循环
        if (num <= 1) return num;
        return fib1(num - 1) + fib1(num - 2);
    }

    /**
     * 另外一种方式实现斐波那契数列, 这种方式的效率高很多
     */
    public static int fib2(int num) {

        if (num <= 1) return num;

        int first = 0;
        int second = 1;

        while (num-- > 1) {
            second += first;
            first = second - first;
        }

        return second;
    }

    public static int fib3(int num) {
        double c = Math.sqrt(5);
        return (int) ((Math.pow((1 + c) / 2, num) - Math.pow((1 - c) / 2, num)) / c);
    }


    public static void main(String[] args) {

        int num = 45;

        TimeTool.check("fib1", () -> {
            System.out.println(fib1(num));
        });

        TimeTool.check("fib2", () -> {
            System.out.println(fib2(num));
        });
    }
}
/*
执行结果:
    【fib1】
    开始：11:42:51.323
    1134903170
    结束：11:42:56.410
    耗时：5.086秒
    -------------------------------------
    【fib2】
    开始：11:42:56.413
    1134903170
    结束：11:42:56.413
    耗时：0.0秒
    -------------------------------------
 */

