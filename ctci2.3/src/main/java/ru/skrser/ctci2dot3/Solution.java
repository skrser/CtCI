package ru.skrser.ctci2dot3;

public class Solution {

    /**
     * Deletes node in the middle of list. E.g. deleting '2' in 1 -> 2 -> 3 gives 1 -> 3
     * Computation complexity = O(1)
     * Memory consumption = O(1)
     *
     * @param node to delete. If node is null or last in list, {@link IllegalArgumentException} would be thrown
     */
    public static void delete(Node node) {
        if (node == null || node.next == null)
            throw new IllegalArgumentException("Node must be in the middle of list");

        node.data = node.next.data;
        node.next = node.next.next;
    }

}
