package ru.skrser.ctci4dot5;

public class SolutionDepth implements SolutionInterface {

    /**
     * Computation complexity = O(N)
     * Memory consumption = O(log N)(for stack)
     */
    public boolean isBinarySearchTree(Node root) {
        if (root == null)
            return true;
        if (root.left != null && root.left.value > root.value)
            return false;
        if (root.right != null && root.right.value <= root.value)
            return false;
        return isBinarySearchTree(root.left) && isBinarySearchTree(root.right);
    }
}
