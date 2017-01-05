package ru.skrser.ctci2dot6.test;

import org.junit.Test;
import ru.skrser.ctci2dot6.Node;
import ru.skrser.ctci2dot6.Solution;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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
        Node head1 = generateLinkedList();
        head1.next.next.next.next.next = head1.next.next;
        assertEquals(head1.next.next, Solution.findLoopStart(head1));
        assertNotEquals(head1.next.next.next, Solution.findLoopStart(head1));

        Node head2 = generateLinkedList();
        head2.next.next.next.next.next = head2;
        assertEquals(head2, Solution.findLoopStart(head2));

        Node head3 = generateLinkedList();
        head3.next.next.next.next.next = head3.next.next.next.next;
        assertEquals(head3.next.next.next.next, Solution.findLoopStart(head3));

        assertEquals(null, Solution.findLoopStart(null));
        assertEquals(null, Solution.findLoopStart(new Node()));
        Node head4 = generateLinkedList();
        assertEquals(null, Solution.findLoopStart(head4));
    }


}
