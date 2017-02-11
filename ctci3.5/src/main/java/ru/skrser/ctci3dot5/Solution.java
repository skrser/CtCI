package ru.skrser.ctci3dot5;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Queue implementation using 2 stacks
 * <p>
 * Pushing, then polling n elements:
 * Computational complexity = O(n^2)
 * Memory consumption = O(n)
 */
public class Solution implements MyQueue {

    private Deque<Integer> queueStack = new ArrayDeque<Integer>();
    private Deque<Integer> bufferStack = new ArrayDeque<Integer>();

    public void add(int value) {
        while (!queueStack.isEmpty())
            bufferStack.push(queueStack.pop());
        queueStack.push(value);
        while (!bufferStack.isEmpty())
            queueStack.push(bufferStack.pop());
    }

    public int poll() {
        return queueStack.pop();
    }
}
