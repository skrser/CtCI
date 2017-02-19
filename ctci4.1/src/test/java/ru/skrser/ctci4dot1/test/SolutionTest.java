package ru.skrser.ctci4dot1.test;

import org.junit.Test;
import ru.skrser.ctci4dot1.Node;
import ru.skrser.ctci4dot1.Solution;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void testSolution() {
        assertTrue(Solution.isBalanced(null));

        Node root = new Node();
        assertTrue(Solution.isBalanced(root));

        root.left = new Node();
        assertTrue(Solution.isBalanced(root));

        root.right = new Node();
        assertTrue(Solution.isBalanced(root));

        root.right.left = new Node();
        assertTrue(Solution.isBalanced(root));

        root.right.left.left = new Node();
        assertFalse(Solution.isBalanced(root));

        root.right.left.left = null;
        assertTrue(Solution.isBalanced(root));

        root.left.right = new Node();
        assertTrue(Solution.isBalanced(root));

        root.left = null;
        assertFalse(Solution.isBalanced(root));
    }


}
