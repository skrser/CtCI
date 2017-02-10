package ru.skrser.ctci3dot3.test;

import org.junit.Test;
import ru.skrser.ctci3dot3.SetOfStacks;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void testStack() {
        Deque<Integer> referenceStackImpl = new LinkedList<Integer>();
        SetOfStacks stack = new SetOfStacks();
        for (int i = 0; i < 50; i++) {
            referenceStackImpl.push(i);
            assertEquals(i / 10, stack.push(i));
        }
        for (int i : referenceStackImpl)
            assertEquals(i, stack.pop());
    }

    @Test
    public void testStackPopAt() {
        SetOfStacks stack = new SetOfStacks();
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
        SetOfStacks stack = new SetOfStacks();
        System.out.println(stack.pop());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsExceptionLess() {
        SetOfStacks stack = new SetOfStacks();
        stack.push(1);
        stack.popAt(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBoundsExceptionGreater() {
        SetOfStacks stack = new SetOfStacks();
        stack.push(1);
        stack.popAt(2);
    }
}
