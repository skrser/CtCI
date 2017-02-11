package ru.skrser.ctci3dot3.test;

import org.junit.Test;
import ru.skrser.ctci3dot3.Solution;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void testStack() {
        Deque<Integer> referenceStackImpl = new LinkedList<Integer>();
        Solution stack = new Solution();
        for (int i = 0; i < 50; i++) {
            referenceStackImpl.push(i);
            assertEquals(i / 10, stack.push(i));
        }
        while (!referenceStackImpl.isEmpty())
            assertEquals((int) referenceStackImpl.pop(), stack.pop());
    }

    @Test
    public void testStackPopAt() {
        Solution stack = new Solution();
        for (int i = 1; i <= 30; i++) {
            stack.push(i);
        }
        for (int i = 20; i > 10; i--)
            assertEquals(i, stack.popAt(1));
        for (int i = 30; i > 20; i--)
            assertEquals(i, stack.popAt(1));
        for (int i = 10; i > 0; i--)
            assertEquals(i, stack.popAt(0));
    }

    @Test(expected = NoSuchElementException.class)
    public void testNoSuchElementException() {
        Solution stack = new Solution();
        System.out.println(stack.pop());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsExceptionLess() {
        Solution stack = new Solution();
        stack.push(1);
        stack.popAt(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsExceptionGreater() {
        Solution stack = new Solution();
        stack.push(1);
        stack.popAt(2);
    }
}
