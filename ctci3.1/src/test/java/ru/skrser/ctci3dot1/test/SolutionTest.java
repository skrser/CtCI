package ru.skrser.ctci3dot1.test;

import org.junit.Test;
import ru.skrser.ctci3dot1.Solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SolutionTest {

    @Test
    public void testStacks() {
        Solution stacks = new Solution();
        assertNull(stacks.pick(0));
        assertNull(stacks.pop(1));

        stacks.push(0, 1);
        stacks.push(0, 2);
        stacks.push(1, 11);
        stacks.push(0, 3);
        stacks.push(2, 21);
        stacks.push(1, 12);

        assertEquals(Integer.valueOf(3), stacks.pop(0));
        assertEquals(Integer.valueOf(2), stacks.pick(0));
        assertEquals(Integer.valueOf(2), stacks.pop(0));
        assertEquals(Integer.valueOf(1), stacks.pop(0));
        assertNull(stacks.pop(0));
        assertEquals(Integer.valueOf(12), stacks.pop(1));
        assertEquals(Integer.valueOf(11), stacks.pop(1));
        assertNull(stacks.pop(1));
        assertEquals(Integer.valueOf(21), stacks.pick(2));
        assertEquals(Integer.valueOf(21), stacks.pop(2));
        assertNull(stacks.pop(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testOutOfBoundsStackNum() {
        Solution stacks = new Solution();
        stacks.push(3, 5);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testStackOverflow() {
        Solution stacks = new Solution();

        stacks.push(0, 1);
        stacks.push(0, 2);
        stacks.push(1, 11);
        stacks.push(0, 3);
        stacks.push(2, 21);
        stacks.push(1, 12);
        stacks.push(0, 4);
        stacks.push(0, 5);
        stacks.push(0, 6);
    }

}
