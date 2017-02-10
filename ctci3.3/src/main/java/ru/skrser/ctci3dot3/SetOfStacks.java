package ru.skrser.ctci3dot3;

import java.util.*;

public class SetOfStacks {

    private static final int THRESHOLD = 10;

    private List<Deque<Integer>> stacks = new ArrayList<Deque<Integer>>();

    /**
     * Pushes value to set of stacks
     *
     * @param value to be pushed
     * @return stack index within set
     */
    public int push(int value) {
        Deque<Integer> stack;
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() == THRESHOLD) {
            stack = new ArrayDeque<Integer>();
            stacks.add(stack);
        } else
            stack = stacks.get(stacks.size() - 1);
        stack.push(value);
        return stacks.size() - 1;
    }

    /**
     * Pops value from set of stacks
     *
     * @return value from last stack
     * @throws NoSuchElementException if this stack is empty
     */
    public int pop() {
        try {
            return popAt(stacks.size() - 1);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchElementException();
        }
    }

    /**
     * Pops value from specific stack
     *
     * @param index of stack within set
     * @return value from specified stack
     * @throws IndexOutOfBoundsException if index is out of set bounds
     */

    public int popAt(int index) {
        if (index < 0 || index > stacks.size() - 1)
            throw new IndexOutOfBoundsException();
        Deque<Integer> stack = stacks.get(index);
        int value = stack.pop();
        if (stack.isEmpty())
            stacks.remove(index);
        return value;
    }
}
