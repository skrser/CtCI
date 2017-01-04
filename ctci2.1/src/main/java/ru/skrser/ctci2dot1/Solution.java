package ru.skrser.ctci2dot1;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Removes duplicates within linked list
     * Computational complexity = O(N)
     * Memory consumption = O(N)
     *
     * @param head reference to list's head node
     */
    public static void removeDuplicates(Node head) {
        Set<Integer> foundValues = new HashSet<Integer>();
        Node current = head;

        while (current != null) {
            if (foundValues.contains(current.data)) {
                deleteNode(current);
            } else
                foundValues.add(current.data);
            current = current.next;
        }
    }

    private static void deleteNode(Node node) {
        if (node != null) {
            if (node.previous != null)
                node.previous.next = node.next;
            if (node.next != null)
                node.next.previous = node.previous;
        }
    }

    /**
     * Removes duplicates within linked list
     * Computational complexity = O(N^2)
     * Memory consumption = O(1)
     *
     * @param head reference to list's head node
     */
    public static void removeDuplicates2(Node head) {
        Node i = head, j;

        while (i != null) {
            j = head.next;
            while (j != null) {
                if (i.data == j.data) {
                    deleteNode(j);
                }
                j = j.next;
            }
            i = i.next;
        }
    }

}
