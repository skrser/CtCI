package ru.skrser.ctci3dot6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Sort stack in ascending order using stacks
     * Computation complexity = O(N^2)
     * Memory consumption = O(N), no data copy, but in worst case N stacks is needed
     *
     * @param stack to sort
     */
    public static void sort(Deque<Integer> stack) {
        Set<Deque<Integer>> setOfStacks = decompose(stack);
        compose(stack, setOfStacks);
    }

    private static Set<Deque<Integer>> decompose(Deque<Integer> stack) {
        Set<Deque<Integer>> setOfStacks = new HashSet<Deque<Integer>>();
        while (!stack.isEmpty()) {
            int value = stack.pop();
            Deque<Integer> suitableStack = findSuitableStack(setOfStacks, value);
            if (suitableStack == null) {
                suitableStack = new ArrayDeque<Integer>();
                setOfStacks.add(suitableStack);
            }
            suitableStack.push(value);
        }
        return setOfStacks;
    }

    private static Deque<Integer> findSuitableStack(Set<Deque<Integer>> setOfStacks, int value) {
        for (Deque<Integer> stack : setOfStacks) {
            if (stack.peek() >= value)
                return stack;
        }
        return null;
    }


    private static void compose(Deque<Integer> stack, Set<Deque<Integer>> setOfStacks) {
        while (!setOfStacks.isEmpty()) {
            Deque<Integer> minValueStack = findMinValueStack(setOfStacks);
            stack.push(minValueStack.pop());
            while (!minValueStack.isEmpty() && minValueStack.peek().equals(stack.peek())) {
                stack.push(minValueStack.pop());
            }
            if (minValueStack.isEmpty())
                setOfStacks.remove(minValueStack);
        }
    }

    private static Deque<Integer> findMinValueStack(Set<Deque<Integer>> setOfStacks) {
        Deque<Integer> minValueStack = null;
        for (Deque<Integer> stack : setOfStacks) {
            if (minValueStack == null || minValueStack.peek() > stack.peek())
                minValueStack = stack;
        }
        return minValueStack;
    }

}