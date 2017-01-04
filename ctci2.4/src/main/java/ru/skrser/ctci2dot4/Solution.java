package ru.skrser.ctci2dot4;

public class Solution {

    /**
     * Partitions list, so values smaller then x would come before equal or greater.
     * Saves inner structure of list (order within groups).
     * Computational complexity = O(n)
     * Memory consumption = O(1)
     *
     * @param head reference to list's head node
     * @param x    value to divide list
     * @return reference to reordered list's head node
     */
    public static Node partitionList(Node head, int x) {
        Node smallerHead = null, smallerCursor = null;
        Node greaterOrEqualHead = null, greaterOrEqualCursor = null;
        Node current = head;

        while (current != null) {
            if (current.data < x) {
                if (smallerHead == null)
                    smallerHead = current;
                if (smallerCursor != null)
                    smallerCursor.next = current;
                smallerCursor = current;
            } else {
                if (greaterOrEqualHead == null)
                    greaterOrEqualHead = current;
                if (greaterOrEqualCursor != null)
                    greaterOrEqualCursor.next = current;
                greaterOrEqualCursor = current;
            }
            current = current.next;
        }

        if (smallerCursor != null) {
            smallerCursor.next = greaterOrEqualHead;
            if (greaterOrEqualCursor != null)
                greaterOrEqualCursor.next = null;
            return smallerHead;
        } else
            return greaterOrEqualHead;
    }

}
