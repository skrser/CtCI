package ru.skrser.ctci4dot2.test;

import org.junit.Test;
import ru.skrser.ctci4dot2.Node;
import ru.skrser.ctci4dot2.Solution;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void testSolution() {
        assertFalse(Solution.areConnected(null, null));
        assertFalse(Solution.areConnected(new Node(), null));
        assertFalse(Solution.areConnected(new Node(), new Node()));
        Node n1 = new Node();
        Node n2 = new Node();
        n1.linkedNodes.add(n2);
        assertTrue(Solution.areConnected(n1, n2));
        assertTrue(Solution.areConnected(n2, n1));

        n1.linkedNodes.add(n1);
        assertTrue(Solution.areConnected(n1, n2));

        n1.linkedNodes.clear();
        n1.linkedNodes.add(n1);
        assertFalse(Solution.areConnected(n1, n2));

        n1.linkedNodes.clear();
        Node previousNode = n1;
        Node nextNode;
        Node middle = new Node();
        for (int i = 0; i < 10; i++) {
            nextNode = new Node();
            previousNode.linkedNodes.add(nextNode);
            previousNode = nextNode;
            if (i == 5)
                middle = nextNode;
        }
        previousNode.linkedNodes.add(n2);
        assertTrue(Solution.areConnected(n2, n1));
        middle.linkedNodes.clear();
        assertFalse(Solution.areConnected(n2, n1));
    }


}
