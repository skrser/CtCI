package ru.skrser.ctci2dot2.test;

import org.junit.Test;
import ru.skrser.ctci2dot2.Node;
import ru.skrser.ctci2dot2.Solution;

import static org.junit.Assert.*;

public class SolutionTest {

    private Node generateLinkedList() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        return head;
    }

    @Test
    public void testSolution() {
        Node head = generateLinkedList();
        assertNull(Solution.getKthNode(null, 3));
        assertNull(Solution.getKthNode(head, -1));
        assertNull(Solution.getKthNode(head, 5));
        assertNotNull(Solution.getKthNode(head, 2));
        assertEquals(3, Solution.getKthNode(head, 2).data);
        assertNotNull(Solution.getKthNode(head, 0));
        assertEquals(5, Solution.getKthNode(head, 0).data);
        assertNotNull(Solution.getKthNode(head, 4));
        assertEquals(1, Solution.getKthNode(head, 4).data);
    }

}
