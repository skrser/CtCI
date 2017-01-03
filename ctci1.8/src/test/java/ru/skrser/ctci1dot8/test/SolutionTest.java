package ru.skrser.ctci1dot8.test;

import org.junit.Test;
import ru.skrser.ctci1dot8.Solution;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void testPositive() {
        assertTrue(Solution.isRotation(null, null));
        assertTrue(Solution.isRotation("", ""));
        assertTrue(Solution.isRotation("a", "a"));
        assertTrue(Solution.isRotation("ab", "ab"));
        assertTrue(Solution.isRotation("ab", "ba"));
        assertTrue(Solution.isRotation("result", "sultre"));
        assertTrue(Solution.isRotation("waterbattle", "erbattlewat"));
        assertTrue(Solution.isRotation("waterwa", "wawater"));
        assertTrue(Solution.isRotation("wawater", "wawater"));
    }

    @Test
    public void testNegative() {
        assertFalse(Solution.isRotation(null, ""));
        assertFalse(Solution.isRotation("abc", null));
        assertFalse(Solution.isRotation(null, ""));
        assertFalse(Solution.isRotation("a", "b"));
        assertFalse(Solution.isRotation("abc", "ab"));
        assertFalse(Solution.isRotation("acb", "abc"));
        assertFalse(Solution.isRotation("reesult", "seultre"));
        assertFalse(Solution.isRotation("waterwa", "wewater"));
        assertFalse(Solution.isRotation("waterWa", "wawater"));
    }
}
