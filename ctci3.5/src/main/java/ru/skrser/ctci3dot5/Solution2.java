package ru.skrser.ctci3dot5;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Queue implementation using 2 stacks
 * <p>
 * Pushing, then polling n elements:
 * Computational complexity = O(n)
 * Memory consumption = O(n)
 */
public class Solution2 implements MyQueue {

    private Deque<Integer> forwardStack = new ArrayDeque<Integer>();
    private Deque<Integer> reverseStack = new ArrayDeque<Integer>();

    public void add(int value) {
        forwardStack.push(value);
    }

    public int poll() {
        if (reverseStack.isEmpty()) {
            while (!forwardStack.isEmpty())
                reverseStack.push(forwardStack.pop());
        }
        return reverseStack.pop();
    }
}
