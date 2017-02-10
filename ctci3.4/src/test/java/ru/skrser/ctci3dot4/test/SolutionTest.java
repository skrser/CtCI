package ru.skrser.ctci3dot4.test;

import org.junit.Test;
import ru.skrser.ctci3dot4.Solution;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void testSolution() {
        int towerSize = 20;

        Deque<Integer> tower = new ArrayDeque<Integer>();
        for (int i = towerSize; i > 0; i--)
            tower.push(i);

        Deque<Integer> newTower = Solution.moveTower(tower);

        assertTrue(tower != newTower);
        for (int i = 1; i <= towerSize; i++)
            assertEquals(i, (int) newTower.pop());
    }

    @Test(expected = NullPointerException.class)
    public void testNull() {
        Solution.moveTower(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmpty() {
        Solution.moveTower(new ArrayDeque<Integer>());
    }
}
