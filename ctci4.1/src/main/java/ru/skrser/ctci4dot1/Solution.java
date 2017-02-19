package ru.skrser.ctci4dot1;

public class Solution {

    /**
     * Finds out binary tree height
     *
     * @param node tree root
     * @return tree height, if it is balanced, -1 otherwise. Height of null is 0.
     */
    private static int getHeight(Node node) {
        if (node == null)
            return 0;
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1)
            return -1;

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * Checks if binary tree is balanced
     * Computation complexity = O(N)
     * Memory consumption = O(log N) (for stack)
     *
     * @param root tree root
     * @return true if tree is balanced
     */
    public static boolean isBalanced(Node root) {
        return getHeight(root) != -1;
    }

}
