package ru.skrser.ctci4dot3.test;

import org.junit.Test;
import ru.skrser.ctci4dot3.Node;
import ru.skrser.ctci4dot3.Solution;
import ru.skrser.ctci4dot3.Solution4dot1;

import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void testSolution() {
        testSolution(0);
        testSolution(1);
        testSolution(2);
        testSolution(3);
        testSolution(4);
        testSolution(7);
        testSolution(8);
    }

    private void testSolution(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i + 10;
        }
        Node root = Solution.convertToTree(array);
        assertTrue(isBinarySearchTree(root));
        assertTrue(Solution4dot1.isBalanced(root));
    }

    private boolean isBinarySearchTree(Node root) {
        if (root != null) {
            if (root.left != null)
                if (root.value < root.left.value || !isBinarySearchTree(root.left))
                    return false;
            if (root.right != null)
                if (root.value > root.right.value || !isBinarySearchTree(root.right))
                    return false;
        }
        return true;
    }


}
