package ru.skrser.ctci3dot6.test;

import org.junit.Test;
import ru.skrser.ctci3dot6.Solution;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void testSolution() {
        int stackSize = 50;

        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < stackSize; i++)
            stack.push((int) (Math.random() * stackSize));
        Solution.sort(stack);

        assertEquals(stackSize, stack.size());

        int value = stack.pop();
        while (!stack.isEmpty()) {
            assertTrue(value >= stack.peek());
            value = stack.pop();
        }
    }
}
