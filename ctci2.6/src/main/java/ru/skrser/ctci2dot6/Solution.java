package ru.skrser.ctci2dot6;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    /**
     * Finds loops in linked list
     * Computation complexity = O(N)
     * Memory consumption = O(N)
     *
     * @param head reference to list's head node
     * @return first node in loop (if linked list contains loops), null otherwise
     */
    public static Node findLoopStart(Node head) {
        Set<Node> nodes = new HashSet<Node>();
        Node current = head;

        while (current != null) {
            if (nodes.contains(current))
                return current;
            else
                nodes.add(current);
            current = current.next;
        }
        return null;
    }

}
