package ru.skrser.ctci4dot5.test;

import org.junit.Test;
import ru.skrser.ctci4dot5.Node;
import ru.skrser.ctci4dot5.SolutionDepth;
import ru.skrser.ctci4dot5.SolutionInterface;
import ru.skrser.ctci4dot5.SolutionWidth;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void testSolutions() {
        testSolution(new SolutionDepth());
        testSolution(new SolutionWidth());

    }

    private void testSolution(SolutionInterface solution) {
        assertTrue(solution.isBinarySearchTree(null));
        Node root = new Node(5);
        assertTrue(solution.isBinarySearchTree(root));
        root.left = new Node(4);
        assertTrue(solution.isBinarySearchTree(root));
        root.left.value = 5;
        assertTrue(solution.isBinarySearchTree(root));
        root.left.value = 6;
        assertFalse(solution.isBinarySearchTree(root));
        root.left.value = 4;
        root.right = new Node(6);
        assertTrue(solution.isBinarySearchTree(root));
        root.right.value = 5;
        assertFalse(solution.isBinarySearchTree(root));
        root.right.value = 6;
        root.right.right = new Node(7);
        root.right.right.left = new Node(7);
        root.right.right.right = new Node(8);
        assertTrue(solution.isBinarySearchTree(root));
    }

}
