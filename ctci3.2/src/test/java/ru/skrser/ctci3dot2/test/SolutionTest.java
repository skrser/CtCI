package ru.skrser.ctci3dot2.test;

import org.junit.Test;
import ru.skrser.ctci3dot2.Solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SolutionTest {

    @Test
    public void testStacks() {
        Solution stack = new Solution();

        assertNull(stack.pop());
        assertNull(stack.min());

        stack.push(10);
        assertEquals(Integer.valueOf(10), stack.min());
        stack.push(9);
        assertEquals(Integer.valueOf(9), stack.min());
        stack.push(11);
        assertEquals(Integer.valueOf(9), stack.min());
        stack.push(10);
        assertEquals(Integer.valueOf(9), stack.min());
        stack.push(8);
        assertEquals(Integer.valueOf(8), stack.min());
        stack.push(10);
        assertEquals(Integer.valueOf(8), stack.min());
        assertEquals(Integer.valueOf(10), stack.pop());
        assertEquals(Integer.valueOf(8), stack.min());
        stack.push(7);

        assertEquals(Integer.valueOf(7), stack.min());

        assertEquals(Integer.valueOf(7), stack.pop());
        assertEquals(Integer.valueOf(8), stack.min());
        assertEquals(Integer.valueOf(8), stack.pop());
        assertEquals(Integer.valueOf(9), stack.min());
        assertEquals(Integer.valueOf(10), stack.pop());
        assertEquals(Integer.valueOf(9), stack.min());
        stack.push(7);
        assertEquals(Integer.valueOf(7), stack.min());
        assertEquals(Integer.valueOf(7), stack.pop());
        assertEquals(Integer.valueOf(9), stack.min());
        assertEquals(Integer.valueOf(11), stack.pop());
        assertEquals(Integer.valueOf(9), stack.min());
        assertEquals(Integer.valueOf(9), stack.pop());
        assertEquals(Integer.valueOf(10), stack.min());
        assertEquals(Integer.valueOf(10), stack.pop());
        assertNull(stack.pop());
        assertNull(stack.min());
    }
}
