package ru.skrser.ctci3dot4;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    /**
     * Tower of Hanoi puzzle
     * Computation complexity = O(2^n)
     * Memory consumption = O(n)
     *
     * @param source tower
     * @return target tower
     */
    public static Deque<Integer> moveTower(Deque<Integer> source) {
        if (source == null)
            throw new NullPointerException();
        if (source.isEmpty())
            throw new IllegalArgumentException("Source should not be empty");

        Deque<Integer> buffer = new ArrayDeque<Integer>(source.size());
        Deque<Integer> target = new ArrayDeque<Integer>(source.size());
        move(source.size(), target, source, buffer);
        return target;
    }

    private static void move(int num, Deque<Integer> target, Deque<Integer> source, Deque<Integer> buffer) {
        if (num > 1)
            move(num - 1, buffer, source, target);
        target.push(source.pop());
        if (num > 1)
            move(num - 1, target, buffer, source);
    }

}
