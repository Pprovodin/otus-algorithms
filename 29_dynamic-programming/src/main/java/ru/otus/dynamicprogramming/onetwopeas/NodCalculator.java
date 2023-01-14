package ru.otus.dynamicprogramming.onetwopeas;

/**
 * @link https://www.robotsharp.info/?page=TaskInfo&taskId=3704&langId=java
 */
public class NodCalculator implements Nod {

    @Override
    public int calculateNod(int a, int b) {
        if (a == b) return a;
        if (even(a) && even(b)) return calculateNod(a >> 1, b >> 1) << 1;
        if (even(a) && odd(b)) return calculateNod(a >> 1, b);
        if (odd(a) && even(b)) return calculateNod(a, b >> 1);
        if (a > b) {
            return calculateNod((a - b) >> 1, b);
        }
        else {
            return calculateNod(a, (b - a) >> 1);
        }
    }

    public static boolean even(int number) {
        return (number & 1) == 0;
    }

    public static boolean odd(int number) {
        return (number & 1) == 1;
    }
}
