package ru.skrser.ctci4dot6.test;

import org.junit.Test;
import ru.skrser.ctci4dot6.Node;
import ru.skrser.ctci4dot6.Solution;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void testSolution() {
        assertEquals(null, Solution.findNextNode(null));
        assertEquals(null, Solution.findNextNode(new Node(3, null)));

        Node root = new Node(7, null);
        root.left = new Node(4, root);
        root.left.left = new Node(2, root.left);
        root.left.right = new Node(8, root.left);
        root.right = new Node(10, root);
        root.right.left = new Node(3, root.right);
        root.right.right = new Node(12, root.right);

        assertEquals(root.right.left, Solution.findNextNode(root.left.left)); // 2 -> 3
        assertEquals(root.left, Solution.findNextNode(root.right.left)); // 3 -> 4
        assertEquals(root, Solution.findNextNode(root.left)); // 4 -> 7
        assertEquals(root.left.right, Solution.findNextNode(root)); // 7 -> 8
        assertEquals(root.right, Solution.findNextNode(root.left.right)); // 8 -> 10
        assertEquals(root.right.right, Solution.findNextNode(root.right)); // 10 -> 12
        assertEquals(null, Solution.findNextNode(root.right.right)); // 12 -> null

    }

}
