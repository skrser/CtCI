package ru.skrser.ctci2dot7.test;

import org.junit.Test;
import ru.skrser.ctci2dot7.Node;
import ru.skrser.ctci2dot7.Solution;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    private Node generateLinkedList() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        return head;
    }

    private Node generateEvenPalindromeLinkedList() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        return head;
    }

    private Node generateOddPalindromeLinkedList() {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        return head;
    }

    @Test
    public void testSolution() {
        assertFalse(Solution.isPalindrome(generateLinkedList()));
        assertTrue(Solution.isPalindrome(generateEvenPalindromeLinkedList()));
        assertTrue(Solution.isPalindrome(generateOddPalindromeLinkedList()));
        assertTrue(Solution.isPalindrome(new Node()));
        assertTrue(Solution.isPalindrome(null));
    }
}
