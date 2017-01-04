package ru.skrser.ctci2dot1.test;

import org.junit.Test;
import ru.skrser.ctci2dot1.Node;
import ru.skrser.ctci2dot1.Solution;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertFalse;

public class SolutionTest {

    private final int LIST_SIZE = 50;

    private Node generateLinkedList() {
        Node head = new Node();
        head.data = (int) (Math.random() * LIST_SIZE * 0.4);
        Node previous = head;
        for (int i = 1; i < LIST_SIZE; i++) {
            Node node = new Node();
            node.data = (int) (Math.random() * LIST_SIZE * 0.4);

            previous.next = node;
            node.previous = previous;
            previous = node;
        }
        return head;
    }

    private boolean containsDuplicates(Node head) {
        Set<Integer> foundValues = new HashSet<Integer>();
        Node current = head;
        while (current != null) {
            if (foundValues.contains(current.data))
                return true;
            else
                foundValues.add(current.data);
            current = current.next;
        }
        return false;
    }

    private void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null)
                System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    @Test
    public void testSolution1() {
        Node head;
        do {
            head = generateLinkedList();
        } while (!containsDuplicates(head));

        Solution.removeDuplicates(head);
        assertFalse(containsDuplicates(head));
    }

    @Test
    public void testSolution2() {
        Node head;
        do {
            head = generateLinkedList();
        } while (!containsDuplicates(head));

        Solution.removeDuplicates2(head);
        assertFalse(containsDuplicates(head));
    }

    @Test
    public void testExtremes() {
        Solution.removeDuplicates(null);
        Solution.removeDuplicates2(null);
        Solution.removeDuplicates(new Node());
        Solution.removeDuplicates2(new Node());
    }

}
