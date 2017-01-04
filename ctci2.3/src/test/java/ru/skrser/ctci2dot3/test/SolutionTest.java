package ru.skrser.ctci2dot3.test;

import org.junit.Test;
import ru.skrser.ctci2dot3.Node;
import ru.skrser.ctci2dot3.Solution;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private Node generateLinkedList() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        return head;
    }

    private String printList(Node head) {
        StringBuilder sb = new StringBuilder();

        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null)
                sb.append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }

    @Test
    public void testPositive() {
        Node head = generateLinkedList();
        Solution.delete(head.next.next);
        assertEquals("1 -> 2 -> 4 -> 5", printList(head));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNull() {
        Solution.delete(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteLastNode() {
        Node head = generateLinkedList();
        Solution.delete(head.next.next.next.next);
    }

}
