package ru.skrser.ctci4dot4.test;

import org.junit.Test;
import ru.skrser.ctci4dot4.Node;
import ru.skrser.ctci4dot4.Solution;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void testSolution() {
        List<List<Node>> result = Solution.getLists(null);
        assertTrue(result.isEmpty());

        Node root = new Node();
        result = Solution.getLists(root);
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).size());

        root.right = new Node();
        result = Solution.getLists(root);
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).size());
        assertEquals(1, result.get(1).size());

        root.left = new Node();
        result = Solution.getLists(root);
        assertEquals(2, result.size());
        assertEquals(1, result.get(0).size());
        assertEquals(2, result.get(1).size());

        root.left.left = new Node();
        result = Solution.getLists(root);
        assertEquals(3, result.size());
        assertEquals(1, result.get(0).size());
        assertEquals(2, result.get(1).size());
        assertEquals(1, result.get(2).size());

        root.left.left.right = new Node();
        root.left.left.left = new Node();
        result = Solution.getLists(root);
        assertEquals(4, result.size());
        assertEquals(1, result.get(0).size());
        assertEquals(2, result.get(1).size());
        assertEquals(1, result.get(2).size());
        assertEquals(2, result.get(3).size());
    }


}
