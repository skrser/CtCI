package ru.skrser.ctci4dot5;

import java.util.Deque;
import java.util.LinkedList;

public class SolutionWidth implements SolutionInterface {

    /**
     * Computation complexity = O(N)
     * Memory consumption = O(log N) (for queue)
     */
    public boolean isBinarySearchTree(Node root) {
        Deque<Node> queue = new LinkedList<Node>();
        queue.push(root);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            if (n != null) {
                queue.push(n.left);
                queue.push(n.right);
                if ((n.left != null && n.left.value > n.value)
                        || (n.right != null && n.right.value <= n.value))
                    return false;
            }
        }
        return true;
    }
}
