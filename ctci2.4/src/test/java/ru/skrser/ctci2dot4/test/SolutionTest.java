package ru.skrser.ctci2dot4.test;

import org.junit.Test;
import ru.skrser.ctci2dot4.Node;
import ru.skrser.ctci2dot4.Solution;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    private final int LIST_SIZE = 50;
    private final double DISPERSION = 0.4;

    private Node generateLinkedList() {
        Node head = new Node((int) (Math.random() * LIST_SIZE * DISPERSION));
        Node previous = head;
        for (int i = 1; i < LIST_SIZE; i++) {
            previous.next = new Node((int) (Math.random() * LIST_SIZE * DISPERSION));
            previous = previous.next;
        }
        return head;
    }

    @Test
    public void testMiddle() {
        testX(10);
    }

    @Test
    public void testMinus() {
        testX(-1);
    }

    @Test
    public void testPlus() {
        testX(30);
    }

    private void testX(int x) {
        Node head = generateLinkedList();
        Node cursor = Solution.partitionList(head, x);
        boolean beforeX = true;

        while (cursor != null) {
            if (cursor.data >= x) {
                beforeX = false;
            } else
                assertTrue(beforeX);
            cursor = cursor.next;
        }
    }

    @Test
    public void testNull() {
        assertNull(Solution.partitionList(null, 5));
    }

}
