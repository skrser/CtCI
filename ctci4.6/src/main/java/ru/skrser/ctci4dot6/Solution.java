package ru.skrser.ctci4dot6;

public class Solution {

    private static Node getClosestToBorder(Node node, int value) {
        if (node == null)
            return null;
        Node leftCandidate = getClosestToBorder(node.left, value);
        Node rightCandidate = getClosestToBorder(node.right, value);
        Node closestChild;
        if (leftCandidate == null)
            closestChild = rightCandidate;
        else if (rightCandidate == null)
            closestChild = leftCandidate;
        else
            closestChild = leftCandidate.value < rightCandidate.value ? leftCandidate : rightCandidate;
        if (node.value <= value)
            return closestChild;
        else
            return (closestChild != null && closestChild.value < node.value) ? closestChild : node;
    }

    /**
     * Finds node with closest greater value
     * Computational complexity = O(N)
     * Memory consumption = O(log N) (for stack)
     *
     * @param node reference to any node in binary search tree. In fact works for any binary tree
     * @return node with closest greater value or null if given node is greatest
     */
    public static Node findNextNode(Node node) {
        if (node == null)
            return null;
        int value = node.value;
        Node root = node;
        while (root.parent != null)
            root = root.parent;
        return getClosestToBorder(root, value);
    }

}
