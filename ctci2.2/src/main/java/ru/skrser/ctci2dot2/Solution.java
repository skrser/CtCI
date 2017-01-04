package ru.skrser.ctci2dot2;

public class Solution {

    /**
     * Returns Kth node from the end of list
     * Computation complexity = O(n)
     * Memory consumption = O(1)
     *
     * @param head reference to list's head node
     * @param k    number of required node. Should be >=0, < list size
     * @return Kth node, null if k < 0 or if k >= list size
     */
    public static Node getKthNode(Node head, int k) {
        if (head == null || k < 0)
            return null;

        int delta = 0;
        Node current = head;
        Node kCursor = head;
        while (current.next != null) {
            if (delta < k)
                delta++;
            else
                kCursor = kCursor.next;
            current = current.next;
        }
        return delta == k ? kCursor : null;
    }
}
